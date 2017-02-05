package com.kitchen.psc.court;

import com.kitchen.psc.resource.EmbeddableResourceAssemblerSupport;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Kevin Chen
 */
@Component
public class CourtResourceAssembler extends EmbeddableResourceAssemblerSupport<CourtDB, CourtResource, CourtController> {
	public CourtResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		super(entityLinks, relProvider, CourtController.class, CourtResource.class);
	}

	@Override
	public Link linkToSingleResource(CourtDB court)
	{
		return entityLinks.linkToSingleResource(CourtResource.class, court.getId());
	}

	@Override
	public CourtResource toResource(CourtDB court)
	{
		final CourtResource courtResource;

		courtResource = createResourceWithId(court.getId(), court);
		courtResource.setResourceId(court.getId());
		courtResource.setName(court.getName());
		courtResource.setNumber(court.getNumber());

		courtResource.add(
			linkTo(methodOn(CourtController.class).getCourt(court.getId()))
				.withRel(relProvider.getItemResourceRelFor(CourtResource.class)));

		return courtResource;
	}
}
