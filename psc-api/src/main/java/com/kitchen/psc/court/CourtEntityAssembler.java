package com.kitchen.psc.court;

import org.springframework.stereotype.Component;

/**
 * @author Kevin Chen
 */
@Component
public class CourtEntityAssembler {
	public CourtDB createEntity(CourtResource courtResource) {
		CourtDB court;

		court = new CourtDB();
		court.setNumber(courtResource.getNumber());
		court.setName(courtResource.getName());

		return court;
	}
}
