package com.kitchen.psc.court;

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
public class CourtService {

	@Autowired
	private CourtRepository courtRepository;

	@Autowired
	private CourtResourceAssembler courtResourceAssembler;

	@Autowired
	private PagedResourcesAssembler<CourtDB> pagedCourtResourceAssembler;

	@Autowired
	private CourtEntityAssembler courtEntityAssembler;

	public PagedResources<CourtResource> getCourts(Pageable pageable) {
		Page<CourtDB> courts;

		courts = courtRepository.findAllByDeletedDateTimeIsNull(pageable);

		return pagedCourtResourceAssembler.toResource(courts, courtResourceAssembler);
	}

	public CourtResource getCourt(UUID id) {
		CourtDB court;

		court = courtRepository.findOneByIdAndDeletedDateTimeIsNull(id);

		return courtResourceAssembler.toResource(court);
	}

	public CourtResource createCourt(CourtResource courtResource) {
		CourtDB court;

		court = courtEntityAssembler.createEntity(courtResource);
		court = courtRepository.save(court);

		return courtResourceAssembler.toResource(court);
	}

	public CourtResource deleteCourt(UUID id) {
		CourtDB court;
		CourtResource courtResource;

		court = courtRepository.findOneByIdAndDeletedDateTimeIsNull(id);
		courtResource = courtResourceAssembler.toResource(court);
		courtRepository.softDelete(id);

		return courtResource;
	}
}
