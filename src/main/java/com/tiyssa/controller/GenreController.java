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

	
	@RequestMapping(value = "/genre", method = RequestMethod.GET)
	public ResponseEntity<List<Genres>> getAllGenres() {
		List<Genres> genres = genreService.getAllGenres();
		return new ResponseEntity<List<Genres>>(genres, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/genre/{id}", method = RequestMethod.GET)
	public ResponseEntity<Genres> getGenreById(@PathVariable("id") Integer id) {
		Genres genre = genreService.getGenreById(id);
		return new ResponseEntity<Genres>(genre, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/condition/{conVar}", method = RequestMethod.GET)
	public ResponseEntity<List<Genres>> getCondition(@PathVariable("conVar") String condition) {
		List<Genres> Weathercondition = genreService.getCondition(condition);
		return new ResponseEntity<List<Genres>>(Weathercondition, HttpStatus.OK);
	 }

	// @RequestMapping(value= "/condition", method = RequestMethod.GET)
	// public ResponseEntity<Genres> getConditionStatus(@PathVariable("conVar")
	// String condition) {
	// Genres Weathercondition = genreService.getCondition(condition);
	// return new ResponseEntity<Genres>(Weathercondition, HttpStatus.OK);
	// }

}