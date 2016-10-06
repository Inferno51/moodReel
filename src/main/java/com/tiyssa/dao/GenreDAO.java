package com.tiyssa.dao;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tiyssa.MovieGenreWeatherMethods;
import com.tiyssa.entity.Genres;


@Repository
public class GenreDAO implements IGenreDAO {

	String conditions = "Snow";
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;

	@Override
	public Genres getGenreById(Integer genreId) {
		return hibernateTemplate.get(Genres.class, genreId);
	}
	
	public Genres getCondition(String condition) {
		return hibernateTemplate.get(Genres.class, condition);
	}
	
	//@Override
//	public Genres getTableId(int tableId) {
//		return hibernateTemplate.get(Genres.class, tableId);
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genres> getAllGenres() {
		String hql = "SELECT genreById FROM Genres";
		return (List<Genres>) hibernateTemplate.find(hql);
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	
	public List<Genres> getConditionStatus() {
		String hql = "SELECT genreById FROM Genres WHERE weatherCondition LIKE '%"+conditions+"%' " ;
		return (List<Genres>) hibernateTemplate.find(hql);
	}


	

	


	
	
}
