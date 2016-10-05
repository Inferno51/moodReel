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
	
	public Genres getTableId(int tableId) {
	
		return hibernateTemplate.get(Genres.class, tableId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Genres> getAllGenres() {
		String hql = "SELECT genreById FROM Genres WHERE tableId = 2";
		return (List<Genres>) hibernateTemplate.find(hql);
	}	

}
