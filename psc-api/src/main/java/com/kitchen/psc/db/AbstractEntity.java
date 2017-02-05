package com.kitchen.psc.db;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Base class for entity implementations. Uses a {@link UUID} id.
 * @author Kevin Chen
 */
@MappedSuperclass
@ToString
@EqualsAndHashCode
public class AbstractEntity implements Identifiable<UUID> {

	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	@Id
	private UUID id;

	private
	@Version
	Long version;

	@Generated(GenerationTime.INSERT)
	@Column(
		insertable = false,
		updatable = false,
		nullable = false,
		columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private OffsetDateTime createdDateTime;

	@Generated(GenerationTime.ALWAYS)
	@Column(
		insertable = false,
		updatable = false,
		columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private OffsetDateTime lastModifiedDateTime;

	@Column(columnDefinition = "TIMESTAMP null")
	private OffsetDateTime deletedDateTime;

	protected AbstractEntity() {
		this.id = null;
	}

	@Override
	public UUID getId() {
		return id;
	}

	// Should only be used for testing.
	// If you try to call this, Hibernate WILL NOT respect what you set.
	public void setId(UUID id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public OffsetDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public OffsetDateTime getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public OffsetDateTime getDeletedDateTime() {
		return deletedDateTime;
	}

	public void setDeletedDateTime(OffsetDateTime deletedDateTime) {
		this.deletedDateTime = deletedDateTime;
	}
}