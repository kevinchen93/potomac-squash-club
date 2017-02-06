package com.kitchen.psc.member;

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
@ExposesResourceFor(MemberResource.class)
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public PagedResources<MemberResource> getMembers(Pageable pageable) {
		return memberService.getMembers(pageable);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public MemberResource getMember(@PathVariable UUID id) {
		return memberService.getMember(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public MemberResource createPerson(@Validated @RequestBody MemberResource MemberResource) {
		return memberService.createMember(MemberResource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public MemberResource deleteMember(@PathVariable UUID id) {
		return memberService.deleteMember(id);
	}
}
