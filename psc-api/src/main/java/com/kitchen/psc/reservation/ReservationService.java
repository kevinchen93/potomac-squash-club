package com.kitchen.psc.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author Kevin Chen
 */
@Transactional
@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private ReservationResourceAssembler reservationResourceAssembler;

	@Autowired
	private PagedResourcesAssembler<ReservationDB> pagedReservationResourceAssembler;

	@Autowired
	private ReservationEntityAssembler reservationEntityAssembler;

	public PagedResources<ReservationResource> getReservations(Pageable pageable) {
		Page<ReservationDB> reservations;

		reservations = reservationRepository.findAllByDeletedDateTimeIsNull(pageable);

		return pagedReservationResourceAssembler.toResource(reservations, reservationResourceAssembler);
	}

	public ReservationResource getReservation(UUID id) {
		ReservationDB reservation;

		reservation = reservationRepository.findOneByIdAndDeletedDateTimeIsNull(id);

		return reservationResourceAssembler.toResource(reservation);
	}

	public ReservationResource createReservation(ReservationResource reservationResource) {
		ReservationDB reservation;

		reservation = reservationEntityAssembler.createEntity(reservationResource);
		reservation = reservationRepository.save(reservation);

		return reservationResourceAssembler.toResource(reservation);
	}

	public ReservationResource deleteReservation(UUID id) {
		ReservationDB reservation;
		ReservationResource reservationResource;

		reservation = reservationRepository.findOneByIdAndDeletedDateTimeIsNull(id);
		reservationResource = reservationResourceAssembler.toResource(reservation);
		reservationRepository.softDelete(id);

		return reservationResource;
	}
}
