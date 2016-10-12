package com.tiyssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiyssa.MovieGenreWeatherMethods;
import com.tiyssa.dao.IGenreDAO;

import com.tiyssa.entity.Genres;
@Service
@Transactional
public class GenreService implements IGenreService {

	@Autowired
	private IGenreDAO genreDAO;

	@Override
	
	//method to call the getGenreByID method in the GenreDAO class
	public Genres getGenreById(Integer genreId) {
		//passes the variable genreID into the getGenreById method in the GenreDAO class
		Genres obj = genreDAO.getGenreById(genreId);
		return obj;
	}	

	//method to call the getAllGenres method in the GenreDAO class
	@Override
	public List<Genres> getAllGenres(){
		return genreDAO.getAllGenres();
	}

	//method to call the weatherConditions method in the MovieGenreWeatherMethods class and then the getCondition method in the GenreDAO class
	@Override
	public List<Genres> getCondition(String condition) {
		//calls the method weatherConditions in the MovieGenreWeatherMethods class and stores its response to the variable weatherCond
		String weatherCond = MovieGenreWeatherMethods.weatherConditions(condition);
		//passes the variable weatherCond into the getCondition method in the GenreDAO class
		List<Genres> obj = genreDAO.getCondition(weatherCond);
		return obj;
	}

}