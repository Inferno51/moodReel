package com.tiyssa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiyssa.entity.Genres;
import com.tiyssa.service.IGenreService;

@Controller
public class GenreController {

	@Autowired
	private IGenreService genreService;
		
	@RequestMapping("/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
 	}

	@RequestMapping(value="/genre/{id}", method = RequestMethod.GET )
	public ResponseEntity<Genres> getTableId(@PathVariable("id") Integer id) {
		Genres genre = genreService.getTableId(id);
		return new ResponseEntity<Genres>(genre, HttpStatus.OK);
	}

	@RequestMapping(value= "/genre", method = RequestMethod.GET)
	public ResponseEntity<List<Genres>> getAllGenre() {
		List<Genres> genres = genreService.getAllGenres();
		return new ResponseEntity<List<Genres>>(genres, HttpStatus.OK);
	}

} 