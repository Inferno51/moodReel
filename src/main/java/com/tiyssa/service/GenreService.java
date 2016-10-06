package com.tiyssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tiyssa.dao.IGenreDAO;

import com.tiyssa.entity.Genres;
@Service
@Transactional
public class GenreService implements IGenreService {

	@Autowired
	private IGenreDAO genreDAO;

	@Override
	public Genres getGenreById(Integer genreId) {
		Genres obj = genreDAO.getGenreById(genreId);
		return obj;
	}	

	@Override
	public List<Genres> getAllGenres(){
		return genreDAO.getAllGenres();
	}

	@Override
	public Genres getCondition(String condition) {
		Genres obj = genreDAO.getCondition(condition);
		return obj;
	}

	@Override
	public List<Genres> getConditionStatus(){
		return genreDAO.getConditionStatus();
	}

	
	
}
