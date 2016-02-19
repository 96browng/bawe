package uk.nhs.bsa.hecs.directdebit.bawe.service;

import org.springframework.stereotype.Component;

import uk.nhs.bsa.hecs.directdebit.bawe.harness.BaweAccount;

@Component
public class AccountService implements IAccountService {

	/* (non-Javadoc)
	 * @see uk.nhs.bsa.hecs.directdebit.bawe.service.IAccountService#addAccount()
	 */
	@Override
	public int addAccount()
	{
		return 1234;
	}

	@Override
	public BaweAccount getAccount(String bacsAccountRef) {
		return null;
	}

	@Override
	public void editAccount(BaweAccount account) {
	}
}
