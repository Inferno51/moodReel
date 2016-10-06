package com.tiyssa.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="condition_genres")
public class Genres implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="table_id")
    private int tableId;  
	
	@Column(name="condition")
    private String condition;

    @Column(name="genre_by_id")
    private String genreById;

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getGenreById() {
		return genreById;
	}

	public void setGenreById(String genreById) {
		this.genreById = genreById;
	}  	
	
} 