package com.kitchen.psc.member;

import com.kitchen.psc.db.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @author Kevin Chen
 */
public interface MemberRepository extends BaseRepository<MemberDB, UUID> {
	@Modifying
	@Query(
		"UPDATE MemberDB m " +
			"SET m.deletedDateTime = CURRENT_TIMESTAMP " +
			"WHERE m.id = :memberID")
	void softDelete(@Param(value = "memberID") UUID memberID);
}
