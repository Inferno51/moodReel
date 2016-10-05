package com.tiyssa.dao;
import java.util.List;
import com.tiyssa.entity.Genres;
public interface IGenreDAO {
    List<Genres> getAllGenres();
  //  Genres getGenreById(int genreId);
	//Genres getTableId(int tableId);
	Genres getGenreById(Integer genreId);
	
    
    
}
 