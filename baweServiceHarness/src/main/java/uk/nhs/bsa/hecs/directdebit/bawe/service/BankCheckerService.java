package uk.nhs.bsa.hecs.directdebit.bawe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import uk.nhs.bsa.hecs.directdebit.bawe.harness.BankAddress;
import uk.nhs.bsa.hecs.directdebit.bawe.harness.BankDetails;


@Component
public class BankCheckerService implements IBankCheckerService 
{	
	@Override
	public BankAddress getBankAddress(String sortCode)
	{
		return getValidBankAddress(sortCode);
	}
	
	BankAddress getValidBankAddress(String sortCode)
	{
		BankAddress details = new BankAddress();
		details.setBranchName("Something group");
		details.setBankAddress("Addr1, Addr2, Addr3, Addr4, Town, County, Postcode");
		
		return details;
	}


	@Override
	public BankDetails getBankName(String sortCode) {
		return getValidBankName(sortCode);
	}
	
	BankDetails getValidBankName(String sortCode)
	{
		BankDetails details = new BankDetails();
	    details.setBankName("123 Bank");
	    
	    return details;
	}

	@Override
	public boolean validBankDetails(String sortCode, String accountNumber) {
		return true;
	}

	@Override
	public List<String> getBankAccountTransactions(String sortCode,
			String accountNumber) {
		
		List<String> transactions = new ArrayList<String>();
		
		return transactions;
	}
}
