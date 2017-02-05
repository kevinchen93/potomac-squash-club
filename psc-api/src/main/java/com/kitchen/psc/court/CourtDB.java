package com.kitchen.psc.court;

import com.kitchen.psc.db.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Kevin Chen
 */
@Entity
@Table(
	name = "court",
	uniqueConstraints = @UniqueConstraint(name = "IDX_UNIQUE_court_number", columnNames = "number")
)
public class CourtDB extends AbstractEntity {
	@Column(nullable = false, columnDefinition = "tinyint(3) NOT NULL")
	private int number;

	@Column(nullable = false)
	private String name;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
