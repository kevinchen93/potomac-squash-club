package com.kitchen.psc.court;

import com.kitchen.psc.db.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @author Kevin Chen
 */
public interface CourtRepository
	extends BaseRepository<CourtDB, UUID> {

	@Modifying
	@Query(
		"UPDATE CourtDB c " +
			"SET c.deletedDateTime = CURRENT_TIMESTAMP " +
			"WHERE c.id = :courtID")
	void softDelete(@Param(value = "courtID") UUID courtID);
}
