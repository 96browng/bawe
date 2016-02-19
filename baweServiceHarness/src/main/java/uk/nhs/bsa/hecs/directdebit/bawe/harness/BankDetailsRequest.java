/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

/**
 * @author gary
 *
 */
public class BankDetailsRequest extends Request {

	private String sort_code;
	
	private String account_no;

	public String getSort_code() {
		return sort_code;
	}

	public void setSort_code(String sort_code) {
		this.sort_code = sort_code;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankDetailsRequest [sort_code=" + sort_code + ", account_no="
				+ account_no + ", toString()=" + super.toString() + "]";
	}
}
