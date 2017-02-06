package com.kitchen.psc.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Kevin Chen
 */
@RestController
@ExposesResourceFor(ReservationResource.class)
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public PagedResources<ReservationResource> getReservations(Pageable pageable) {
		return reservationService.getReservations(pageable);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ReservationResource getReservation(@PathVariable UUID id) {
		return reservationService.getReservation(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ReservationResource createPerson(@Validated @RequestBody ReservationResource ReservationResource) {
		return reservationService.createReservation(ReservationResource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ReservationResource deleteReservation(@PathVariable UUID id) {
		return reservationService.deleteReservation(id);
	}
}
