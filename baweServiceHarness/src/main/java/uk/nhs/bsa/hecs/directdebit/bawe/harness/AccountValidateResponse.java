/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

/**
 * @author gary
 *
 */
public class AccountValidateResponse extends AllResponse {

	private boolean data;
	
	
	public boolean isData() {
		return data;
	}
	public void setData(boolean data) {
		this.data = data;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountValidateResponse [data=" + data + ", toString()="
				+ super.toString() + "]";
	}
}
