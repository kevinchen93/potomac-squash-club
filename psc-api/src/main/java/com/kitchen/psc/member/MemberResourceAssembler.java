package com.kitchen.psc.member;

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
public class MemberResourceAssembler extends EmbeddableResourceAssemblerSupport<MemberDB, MemberResource, MemberController> {
	public MemberResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
		super(entityLinks, relProvider, MemberController.class, MemberResource.class);
	}

	@Override
	public Link linkToSingleResource(MemberDB member)
	{
		return entityLinks.linkToSingleResource(MemberResource.class, member.getId());
	}

	@Override
	public MemberResource toResource(MemberDB member)
	{
		final MemberResource memberResource;

		memberResource = createResourceWithId(member.getId(), member);
		memberResource.setResourceId(member.getId());
		memberResource.setEmailAddress(member.getEmailAddress());
		memberResource.setFirstName(member.getFirstName());
		memberResource.setLastName(member.getLastName());

		// TODO
//		memberResource.setReservations();

		memberResource.add(
			linkTo(methodOn(MemberController.class).getMember(member.getId()))
				.withRel(relProvider.getItemResourceRelFor(MemberResource.class)));

		return memberResource;
	}
}

