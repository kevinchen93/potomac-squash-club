package com.kitchen.psc.member;

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
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberResourceAssembler memberResourceAssembler;

	@Autowired
	private PagedResourcesAssembler<MemberDB> pagedMemberResourceAssembler;

	@Autowired
	private MemberEntityAssembler memberEntityAssembler;

	public PagedResources<MemberResource> getMembers(Pageable pageable) {
		Page<MemberDB> members;

		members = memberRepository.findAllByDeletedDateTimeIsNull(pageable);

		return pagedMemberResourceAssembler.toResource(members, memberResourceAssembler);
	}

	public MemberResource getMember(UUID id) {
		MemberDB member;

		member = memberRepository.findOneByIdAndDeletedDateTimeIsNull(id);

		return memberResourceAssembler.toResource(member);
	}

	public MemberResource createMember(MemberResource memberResource) {
		MemberDB member;

		member = memberEntityAssembler.createEntity(memberResource);
		member = memberRepository.save(member);

		return memberResourceAssembler.toResource(member);
	}

	public MemberResource deleteMember(UUID id) {
		MemberDB member;
		MemberResource memberResource;

		member = memberRepository.findOneByIdAndDeletedDateTimeIsNull(id);
		memberResource = memberResourceAssembler.toResource(member);
		memberRepository.delete(id);

		return memberResource;
	}
}
