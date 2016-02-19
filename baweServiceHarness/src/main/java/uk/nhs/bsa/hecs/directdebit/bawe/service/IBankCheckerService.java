package uk.nhs.bsa.hecs.directdebit.bawe.service;

import java.util.List;

import uk.nhs.bsa.hecs.directdebit.bawe.harness.BankAddress;
import uk.nhs.bsa.hecs.directdebit.bawe.harness.BankDetails;

public interface IBankCheckerService {

	public abstract BankDetails getBankName(String sortCode);
	
	public abstract BankAddress getBankAddress(String sortCode);

	public abstract boolean validBankDetails(String sortCode, String accountNumber);
	
	public List<String> getBankAccountTransactions(String sortCode, String accountNumber);
}