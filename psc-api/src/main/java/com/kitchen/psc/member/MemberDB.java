package com.kitchen.psc.member;

import com.kitchen.psc.db.AbstractEntity;
import com.kitchen.psc.reservation.ReservationDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

/**
 * @author Kevin Chen
 */
@Entity
@Table(
	name = "member",
//	indexes = @Index(columnList = "emailAddress", name = "IDX_member_emailAddress"),
	uniqueConstraints = @UniqueConstraint(name = "IDX_UNIQUE_member_emailAddress", columnNames = "emailAddress")
)
public class MemberDB extends AbstractEntity {
	@Column(length = 100, nullable = false)
	private String emailAddress;

	@Column(length = 50, nullable = false)
	private String firstName;

	@Column(length = 50, nullable = false)
	private String lastName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "member")
	private List<ReservationDB> reservations;

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

	public List<ReservationDB> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationDB> reservations) {
		this.reservations = reservations;
	}
}
