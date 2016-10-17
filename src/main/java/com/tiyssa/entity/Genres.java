package com.tiyssa.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//This class defines what is in the the condition_genres table in the DB

@Entity
@Table(name="condition_genres")
public class Genres implements Serializable { 

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="table_id")
    private int tableId;  
	
	@Column(name="condition")
    private String weatherCondition;

    @Column(name="genre_by_id")
    private String genreById;
    
    @Column(name="image")
    private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableIdToUse) {
		this.tableId = tableIdToUse;
	}

	public String getCondition() {
		return weatherCondition;
	}

	public void setCondition(String conditionToUse) {
		this.weatherCondition = conditionToUse;
	}

	public String getGenreById() {
		return genreById;
	}

	public void setGenreById(String genreByIdToUse) {
		this.genreById = genreByIdToUse;
	}
	
	
	
	

} 