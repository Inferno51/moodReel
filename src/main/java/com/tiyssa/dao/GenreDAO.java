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

	@Override
	public Genres getGenreById(Integer genreId) {
		return hibernateTemplate.get(Genres.class, genreId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Genres> getAllGenres() {
		String hql = "SELECT genreById FROM Genres";
		return (List<Genres>) hibernateTemplate.find(hql);
	}	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Genres> getCondition(String condition) {
		String hql = "SELECT genreById FROM Genres WHERE weatherCondition = '" + condition + "'";
		return (List<Genres>) hibernateTemplate.find(hql);
	}

	
}