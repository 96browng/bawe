/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

import java.util.Arrays;

/**
 * @author gary
 *
 */
public class AccountTransactionsResponse extends AllResponse {

	private String[] data;
	
	public AccountTransactionsResponse()
	{
		super();
		
		data = new String[] { "" };
	}

	/**
	 * @return the data
	 */
	public String[] getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String[] data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountTransactionsResponse [data=" + Arrays.toString(data)
				+ ", toString()=" + super.toString() + "]";
	}
}
