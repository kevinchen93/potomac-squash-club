package com.kitchen.psc.reservation;

import com.kitchen.psc.db.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @author Kevin Chen
 */
public interface ReservationRepository extends BaseRepository<ReservationDB, UUID> {
	@Modifying
	@Query(
		"UPDATE ReservationDB r " +
			"SET r.deletedDateTime = CURRENT_TIMESTAMP " +
			"WHERE r.id = :reservationID")
	void softDelete(@Param(value = "reservationID") UUID reservationID);
}

