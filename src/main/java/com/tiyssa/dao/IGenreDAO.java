package com.tiyssa.dao;

import java.util.List;
import com.tiyssa.entity.Genres;

public interface IGenreDAO {
	List<Genres> getAllGenres();

	List<Genres> getConditionStatus();

	Genres getGenreById(Integer genreId);

	Genres getCondition(String condition);

	Genres getTableId(int tableId);

}
