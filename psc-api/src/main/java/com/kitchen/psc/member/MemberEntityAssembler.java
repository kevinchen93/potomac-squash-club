package com.kitchen.psc.member;

import org.springframework.stereotype.Component;

/**
 * @author Kevin Chen
 */
@Component
public class MemberEntityAssembler {
	public MemberDB createEntity(MemberResource memberResource) {
		MemberDB member;

		member = new MemberDB();
		member.setEmailAddress(memberResource.getEmailAddress());
		member.setFirstName(memberResource.getFirstName());
		member.setLastName(memberResource.getLastName());
		// TODO
//		member.setReservations();

		return member;
	}
}
