/**
 * 
 */
package uk.nhs.bsa.hecs.directdebit.bawe.harness;

/**
 * @author gary
 *
 */
public abstract class Request {
	private String authentication;

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "Request [authentication=" + authentication + "]";
	}
}
