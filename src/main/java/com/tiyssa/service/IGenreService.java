package com.tiyssa.service;

import java.util.List;


import com.tiyssa.entity.Genres;

public interface IGenreService {
     List<Genres> getAllGenres();
     List<Genres> getConditionStatus();
//     Genres getGenreById(int genreId);
	Genres getGenreById(Integer id);
	Genres getCondition(String condition);
}