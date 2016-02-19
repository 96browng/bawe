package uk.nhs.bsa.hecs.directdebit.bawe.service;

import uk.nhs.bsa.hecs.directdebit.bawe.harness.BaweAccount;

public interface IAccountService {

	public abstract int addAccount();

	public abstract BaweAccount getAccount(String bacsAccountRef);

	public abstract void editAccount(BaweAccount account);

}