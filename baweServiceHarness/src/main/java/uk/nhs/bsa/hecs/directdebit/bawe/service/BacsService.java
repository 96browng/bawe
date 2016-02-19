package uk.nhs.bsa.hecs.directdebit.bawe.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BacsService implements IBacsService {

	/* (non-Javadoc)
	 * @see uk.nhs.bsa.hecs.directdebit.bawe.service.IBacsService#validProcessingDate(java.util.Date)
	 */
	@Override
	public boolean validProcessingDate(Date dateToCheck)
	{
		return true;
	}
}
