package com.kitchen.psc.member;

import com.kitchen.psc.reservation.ReservationResource;
import com.kitchen.psc.resource.ResourceWithEmbeddeds;

import java.util.List;

/**
 * @author Kevin Chen
 */
public class MemberResource extends ResourceWithEmbeddeds {

	private String emailAddress;

	private String firstName;

	private String lastName;

	private List<ReservationResource> reservations;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<ReservationResource> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationResource> reservations) {
		this.reservations = reservations;
	}
}
