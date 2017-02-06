package com.kitchen.psc.reservation;

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
public class ReservationResourceAssembler extends EmbeddableResourceAssemblerSupport<ReservationDB, ReservationResource, ReservationController> {
	public ReservationResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		super(entityLinks, relProvider, ReservationController.class, ReservationResource.class);
	}

	@Override
	public Link linkToSingleResource(ReservationDB reservation) {
		return entityLinks.linkToSingleResource(ReservationResource.class, reservation.getId());
	}

	@Override
	public ReservationResource toResource(ReservationDB reservation) {
		final ReservationResource reservationResource;

		reservationResource = createResourceWithId(reservation.getId(), reservation);
		reservationResource.setResourceId(reservation.getId());
		reservationResource.setCourtID(reservation.getCourt().getId());
		reservationResource.setMemberID(reservation.getMember().getId());
		reservationResource.setTime(reservation.getTime());

		reservationResource.add(
			linkTo(methodOn(ReservationController.class).getReservation(reservation.getId()))
				.withRel(relProvider.getItemResourceRelFor(ReservationResource.class)));

		return reservationResource;
	}
}
