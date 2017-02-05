package com.kitchen.psc.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Kevin Chen
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
	extends JpaRepository<T, ID> {

	T findOneByIdAndDeletedDateTimeIsNull(ID id);

	Iterable<T> findAllByDeletedDateTimeIsNull();

	Page<T> findAllByDeletedDateTimeIsNull(Pageable pageable);

	/*
	 * Get the current unzoned timestamp from the database. JPA can't convert UTC_TIMESTAMP() to OffsetDateTime,
	 * so instead return a LocalDateTime and attach a timezone to it in CurrentDateTimeService
	 *
	 * NOTE: Use CurrentDateTimeService#getCurrentDateTime to get the current OffsetDateTime in UTC
	 */
	@Query(value = "SELECT UTC_TIMESTAMP()", nativeQuery = true)
	LocalDateTime getCurrentUnzonedDateTime();
}
