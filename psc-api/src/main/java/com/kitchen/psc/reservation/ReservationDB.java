package com.kitchen.psc.reservation;

import com.kitchen.psc.court.CourtDB;
import com.kitchen.psc.db.AbstractEntity;
import com.kitchen.psc.member.MemberDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * @author Kevin Chen
 */
@Entity
@Table(
	name = "reservation"
)
public class ReservationDB extends AbstractEntity {
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_reservation_member_member"))
	private MemberDB member;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_reservation_court_court"))
	private CourtDB court;

	@Column
	private OffsetDateTime time;

	public MemberDB getMember() {
		return member;
	}

	public void setMember(MemberDB member) {
		this.member = member;
	}

	public CourtDB getCourt() {
		return court;
	}

	public void setCourt(CourtDB court) {
		this.court = court;
	}

	public OffsetDateTime getTime() {
		return time;
	}

	public void setTime(OffsetDateTime time) {
		this.time = time;
	}
}
