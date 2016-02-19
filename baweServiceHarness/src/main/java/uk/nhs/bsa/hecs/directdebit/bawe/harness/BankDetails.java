/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

/**
 * @author gary
 *
 */
public class BankDetails implements IBaweResponse {

	private String branchName;
	private String bankName;
	
	public BankDetails()
	{
		branchName = "";
		bankName = "";
	}
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return "BankDetails [branchName=" + branchName + ", bankName="
				+ bankName + "]";
	}
}
