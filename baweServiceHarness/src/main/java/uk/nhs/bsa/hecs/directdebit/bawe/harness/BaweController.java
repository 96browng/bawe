package uk.nhs.bsa.hecs.directdebit.bawe.harness;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uk.nhs.bsa.hecs.directdebit.bawe.service.IAccountService;
import uk.nhs.bsa.hecs.directdebit.bawe.service.IBacsService;
import uk.nhs.bsa.hecs.directdebit.bawe.service.IBankCheckerService;
import uk.nhs.bsa.hecs.directdebit.bawe.service.IBaweClientService;

@RestController
@RequestMapping("/")
public class BaweController {

	private static final Logger logger = LoggerFactory
			.getLogger(BaweController.class);

	@Autowired
	private IBankCheckerService bankCheckerService;

	@Autowired
	private IBaweClientService clientService;
	
	@Autowired
	private IBacsService bacsService;
	
	@Autowired
	private IAccountService accountService;

	/**
	 * Handle all exceptions generically.
	 * 
	 * @param e
	 *            - the exception thrown
	 * @return JSON response of the exception.
	 */
	@ExceptionHandler
	public AllResponse handleException(Exception e) {
		return getErrorResponse(e);
	}

	@RequestMapping(value = "/accountChecker/GetBankName", method = RequestMethod.POST)
	public AllResponse getBankName(
			@RequestParam(value = "sort_code", required = true) String sort_code,
			@RequestParam(value = "authentication", required = true) String authentication) {
		logger.debug("Start [getBankName] - SortCode: {}", sort_code);

		clientService.checkClientAuthentication(authentication);

		return getBankName(sort_code);
	}

	AllResponse getBankName(String sortCode) {
		Response response = createBasicValidResponse();

		BankDetails details = bankCheckerService.getBankName(sortCode);
		response.setData(details);

		return response;
	}

	private Response createBasicValidResponse() {
		Response response = new Response();
		response.setSuccess(true);
		return response;
	}

	private ErrorResponse getErrorResponse(Exception e) {
		ErrorResponse response = new ErrorResponse();
		response.setSuccess(false);
		response.setFeedback(e.getMessage());
		response.setData("");
		return response;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/accountChecker/GetBankAddress", method = RequestMethod.POST)
	public AllResponse getBankAddress(
			@RequestParam(value = "sort_code", required = true) String sort_code,
			@RequestParam(value = "authentication", required = true) String authentication) {
		logger.debug("Start [getBankAddress] - SortCode: {}", sort_code);

		clientService.checkClientAuthentication(authentication);

		return getBankAddress(sort_code);
	}

	Response getBankAddress(String sort_code) {
		Response response = createBasicValidResponse();

		BankAddress details = bankCheckerService.getBankAddress(sort_code);
		response.setData(details);
		return response;
	}

	@RequestMapping(value = "/accountChecker/IsAccountNoValid", method = RequestMethod.POST)
	public AccountValidateResponse isAccountNoValid(
			@RequestParam(value = "sort_code", required = true) String sort_code,
			@RequestParam(value = "account_no", required = true) String account_no,
			@RequestParam(value = "authentication", required = true) String authentication) {
		logger.debug("Start [isAccountNoValid] - SortCode: {} Account: {}",
				sort_code, account_no);

		clientService.checkClientAuthentication(authentication);

		AccountValidateResponse response = new AccountValidateResponse();
		response.setSuccess(true);
		response.setData(bankCheckerService.validBankDetails(sort_code,
				account_no));

		return response;
	}

	@RequestMapping(value = "/accountChecker/GetAccountTransactions", method = RequestMethod.POST)
	public AccountTransactionsResponse getAccountTransactions(
			@RequestParam(value = "sort_code", required = true) String sort_code,
			@RequestParam(value = "account_no", required = true) String account_no,
			@RequestParam(value = "authentication", required = true) String authentication) {
		logger.debug(
				"Start [getAccountTransactions] - SortCode: {} Account: {}",
				sort_code, account_no);

		clientService.checkClientAuthentication(authentication);

		AccountTransactionsResponse response = new AccountTransactionsResponse();
		response.setSuccess(true);
		response.setData(bankCheckerService.getBankAccountTransactions(
				sort_code, account_no).toArray(new String[0]));

		return response;
	}

	@RequestMapping(value = "/accountChecker/CheckProcessingDate", method = RequestMethod.POST)
	public AccountValidateResponse checkProcessingDate(
			@RequestParam(value = "date", required = true) Date inputDate,
			@RequestParam(value = "authentication", required = true) String authentication) {
		logger.debug("Start [checkProcessingDate] - Date: {}", inputDate);

		clientService.checkClientAuthentication(authentication);

		AccountValidateResponse response = new AccountValidateResponse();
		response.setSuccess(true);
		response.setData(bacsService.validProcessingDate(inputDate));

		return response;
	}

	/**
	 * 
	 * @param status
	 *            - Can be one of: 1 (denotes Active) 2 (denotes Suspended3
	 *            (denotes Cancelled) 4 (denotes Inactive)
	 * @param planFrequencyType
	 *            - Can be one of: D (denotes DAILY) W (denotes WEEKLY) M
	 *            (denotes MONTHLY (A or B)) LQ (denotes Legal Quarters –
	 *            Collections will be made on the 25th of March, 24th of June,
	 *            29th of September and 24th of December annually. No other
	 *            options are available.) Y (denotes YEARLY) A (denotes AD HOC)
	 *            N (denotes non-DD account)
	 * @param mandateStatus
	 *            - One of: Not Received Received Past
	 * @return
	 */
	@RequestMapping(value = "/accountChecker/AddAccount", method = RequestMethod.POST)
	public Response addAccount(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "address1") String address1,
			@RequestParam(value = "address2") String address2,
			@RequestParam(value = "address3") String address3,
			@RequestParam(value = "address4") String address4,
			@RequestParam(value = "post_code") String post_code,
			@RequestParam(value = "telephone_no") String telephone,
			@RequestParam(value = "fax_no") String fax,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "bank_account_title", required = true) String bankAccountTitle,
			@RequestParam(value = "bank_account_forename", required = true) String bankAccountForename,
			@RequestParam(value = "bank_account_surname", required = true) String bankAccountSurname,
			@RequestParam(value = "sort_code", required = true) String sortcode,
			@RequestParam(value = "account_no", required = true) String accountNo,
			@RequestParam(value = "bacs_account_ref", required = true) String bacsAccountRef,
			@RequestParam(value = "additional_ref") String additionalRef,
			@RequestParam(value = "client_name") String clientName,
			@RequestParam(value = "status") int status,
			@RequestParam(value = "plan_frequency_type") String planFrequencyType,
			@RequestParam(value = "regular_amount") double regularAmount,
			@RequestParam(value = "first_amount") double firstAmount,
			@RequestParam(value = "last_amount") double lastAmount,
			@RequestParam(value = "start_year") int startYear,
			@RequestParam(value = "start_month") int startMonth,
			@RequestParam(value = "start_day") int startDay,
			@RequestParam(value = "end_year") int endYear,
			@RequestParam(value = "end_month") int endMonth,
			@RequestParam(value = "end_day") int endDay,
			@RequestParam(value = "num_debits") int numDebits,
			@RequestParam(value = "mandate_status") String mandateStatus,
			@RequestParam(value = "category") String category,
			@RequestParam(value = "authentication", required = true) String authentication) {
		logger.debug("Start [addAccount]");

		clientService.checkClientAuthentication(authentication);

		Response response = createBasicValidResponse();
		response.setData(addAccount());

		return response;
	}

	AccountAddResponse addAccount() {
		AccountAddResponse accResponse = new AccountAddResponse();
		accResponse.setAccount_id(Integer.toString(accountService.addAccount()));
		return accResponse;
	}
	
	@RequestMapping(value = "/accountChecker/GetAccount", method = RequestMethod.POST)
	public Response getAccount(@RequestParam(value = "bacs_account_ref", required = true) String bacsAccountRef,
			@RequestParam(value = "authentication", required = true) String authentication,
			@RequestParam(value = "client_name") String clientName) {
		
		BaweAccount account = accountService.getAccount(bacsAccountRef);
		
		Response response = createBasicValidResponse();
		response.setData(account);
		return response;
	}
	
	@RequestMapping(value = "/accountChecker/EditAccount", method = RequestMethod.POST)
	public Response editAccount(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "address1") String address1,
			@RequestParam(value = "address2") String address2,
			@RequestParam(value = "address3") String address3,
			@RequestParam(value = "address4") String address4,
			@RequestParam(value = "post_code") String post_code,
			@RequestParam(value = "telephone_no") String telephone,
			@RequestParam(value = "fax_no") String fax,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "bank_account_title", required = true) String bankAccountTitle,
			@RequestParam(value = "bank_account_forename", required = true) String bankAccountForename,
			@RequestParam(value = "bank_account_surname", required = true) String bankAccountSurname,
			@RequestParam(value = "sort_code", required = true) String sortcode,
			@RequestParam(value = "account_no", required = true) String accountNo,
			@RequestParam(value = "bacs_account_ref", required = true) String bacsAccountRef,
			@RequestParam(value = "additional_ref") String additionalRef,
			@RequestParam(value = "client_name") String clientName,
			@RequestParam(value = "status") int status,
			@RequestParam(value = "plan_frequency_type") String planFrequencyType,
			@RequestParam(value = "regular_amount") double regularAmount,
			@RequestParam(value = "first_amount") double firstAmount,
			@RequestParam(value = "last_amount") double lastAmount,
			@RequestParam(value = "start_year") int startYear,
			@RequestParam(value = "start_month") int startMonth,
			@RequestParam(value = "start_day") int startDay,
			@RequestParam(value = "end_year") int endYear,
			@RequestParam(value = "end_month") int endMonth,
			@RequestParam(value = "end_day") int endDay,
			@RequestParam(value = "num_debits") int numDebits,
			@RequestParam(value = "mandate_status") String mandateStatus,
			@RequestParam(value = "category") String category,
			@RequestParam(value = "authentication", required = true) String authentication) {
		logger.debug("Start [editAccount]");

		BaweAccount account = new BaweAccount();
		
		accountService.editAccount(account);

		return createBasicValidResponse();
	}
}
