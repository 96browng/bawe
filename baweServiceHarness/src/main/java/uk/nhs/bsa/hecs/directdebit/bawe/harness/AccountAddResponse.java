/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

/**
 * @author gary
 *
 */
public class AccountAddResponse implements IBaweResponse
{
	private String account_id;

	/**
	 * @return the account_id
	 */
	public String getAccount_id() {
		return account_id;
	}

	/**
	 * @param account_id the account_id to set
	 */
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountAddResponse [account_id=" + account_id + "]";
	}
}
