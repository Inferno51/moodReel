package com.tiyssa.dao;
import java.util.List;
import com.tiyssa.entity.Genres;

public interface IGenreDAO {

	List<Genres> getAllGenres();
	Genres getGenreById(Integer genreId);
	List<Genres> getCondition(String condition);
    
    
}