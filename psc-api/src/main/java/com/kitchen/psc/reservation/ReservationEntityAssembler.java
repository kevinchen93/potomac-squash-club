package com.kitchen.psc.reservation;

import com.kitchen.psc.court.CourtDB;
import com.kitchen.psc.court.CourtRepository;
import com.kitchen.psc.member.MemberDB;
import com.kitchen.psc.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kevin Chen
 */
@Component
public class ReservationEntityAssembler {
	@Autowired
	private CourtRepository courtRepository;

	@Autowired
	private MemberRepository memberRepository;

	public ReservationDB createEntity(ReservationResource reservationResource) {
		ReservationDB reservation;
		CourtDB court;
		MemberDB member;

		court = courtRepository.findOne(reservationResource.getCourtID());
		member = memberRepository.findOne(reservationResource.getMemberID());

		reservation = new ReservationDB();
		reservation.setCourt(court);
		reservation.setMember(member);
		reservation.setTime(reservationResource.getTime());

		return reservation;
	}
}
