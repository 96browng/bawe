/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

/**
 * @author gary
 * 
 */
public class BankAddress implements IBaweResponse {

	private String branchName;
	private String bankAddress;

	public BankAddress() {
		branchName = "";
		bankAddress= "";
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName
	 *            the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the bankAddress
	 */
	public String getBankAddress() {
		return bankAddress;
	}

	/**
	 * @param bankAddress
	 *            the bankAddress to set
	 */
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankAddress [branchName=" + branchName + ", bankAddress="
				+ bankAddress + "]";
	}
}
