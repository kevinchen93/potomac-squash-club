package com.kitchen.psc.reservation;

import com.kitchen.psc.resource.ResourceWithEmbeddeds;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @author Kevin Chen
 */
public class ReservationResource extends ResourceWithEmbeddeds {
	private UUID memberID;

	private UUID courtID;

	private OffsetDateTime time;

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

	public OffsetDateTime getTime() {
		return time;
	}

	public void setTime(OffsetDateTime time) {
		this.time = time;
	}
}
