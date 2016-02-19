/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

/**
 * @author gary
 *
 */
public class Response extends AllResponse
{
	private IBaweResponse data;
	
	
	public IBaweResponse getData() {
		return data;
	}
	public void setData(IBaweResponse data) {
		this.data = data;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [data=" + data + ", toString()=" + super.toString()
				+ "]";
	}
}
