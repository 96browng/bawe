/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

/**
 * @author gary
 *
 */
public class AllResponse {
	
	private String feedback;
	private boolean success;
	
	public AllResponse()
	{
		feedback = "";
	}
	
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@Override
	public String toString() {
		return "Response [feedback=" + feedback
				+ ", success=" + success + "]";
	}
}
