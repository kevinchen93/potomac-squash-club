package com.kitchen.psc.court;

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
@ExposesResourceFor(CourtResource.class)
@RequestMapping("/court")
public class CourtController {
	@Autowired
	private CourtService courtService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public PagedResources<CourtResource> getCourts(Pageable pageable) {
		return courtService.getCourts(pageable);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public CourtResource getCourt(@PathVariable UUID id) {
		return courtService.getCourt(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CourtResource createPerson(@Validated @RequestBody CourtResource courtResource) {
		return courtService.createCourt(courtResource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public CourtResource deleteCourt(@PathVariable UUID id) {
		return courtService.deleteCourt(id);
	}
}
