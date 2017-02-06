package com.kitchen.psc.reservation;

import com.kitchen.psc.resource.ResourceWithEmbeddeds;

import java.util.UUID;

/**
 * @author Kevin Chen
 */
public class ReservationResource extends ResourceWithEmbeddeds {
	private UUID memberID;

	private UUID courtID;

	public UUID getMemberID() {
		return memberID;
	}

	public void setMemberID(UUID memberID) {
		this.memberID = memberID;
	}

	public UUID getCourtID() {
		return courtID;
	}

	public void setCourtID(UUID courtID) {
		this.courtID = courtID;
	}
}
