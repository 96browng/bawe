package uk.nhs.bsa.hecs.directdebit.bawe.service;

import java.util.Date;

public interface IBacsService {

	public abstract boolean validProcessingDate(Date dateToCheck);

}