package com.tiyssa.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tiyssa.entity.Genres;


@Repository
public class GenreDAO implements IGenreDAO {

	
	@Autowired
	private HibernateTemplate  hibernateTemplate;

	//query the DB based on the genre ID and display it's corresponding data
	@Override
	public Genres getGenreById(Integer genreId) {
		return hibernateTemplate.get(Genres.class, genreId);
	}

	//query the DB and list all the data in the genreByID column
	@SuppressWarnings("unchecked")
	@Override
	public List<Genres> getAllGenres() {
		String hql = "SELECT genreById FROM Genres";
		return (List<Genres>) hibernateTemplate.find(hql);
	}	

	//query the DB and list the data from the genreByID column where it matches the passed in condition variable
	@SuppressWarnings("unchecked")
	@Override
	public List<Genres> getCondition(String condition) {
		String hql = "SELECT genreById, image FROM Genres WHERE weatherCondition = '" + condition + "'";
		return (List<Genres>) hibernateTemplate.find(hql);
	}

	
}