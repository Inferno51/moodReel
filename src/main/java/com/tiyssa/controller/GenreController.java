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

	//mapping to display home page
	@RequestMapping("/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}

	//mapping to display all movie genres in the table
	@RequestMapping(value = "/genre", method = RequestMethod.GET)
	public ResponseEntity<List<Genres>> getAllGenres() {
		//calls method in GenreServices to return a list of all genres
		List<Genres> genres = genreService.getAllGenres();
		return new ResponseEntity<List<Genres>>(genres, HttpStatus.OK);
	}

	//mapping to display data for a specific id in the table
	@RequestMapping(value = "/genre/{id}", method = RequestMethod.GET)
	public ResponseEntity<Genres> getGenreById(@PathVariable("id") Integer id) {
		//calls method in GenreServices to return data for a specified id
		Genres genre = genreService.getGenreById(id);
		return new ResponseEntity<Genres>(genre, HttpStatus.OK);
	}

	//mapping to display the data associated with a weather condition retrieved from weather api call
	@RequestMapping(value = "/condition/{conVar}", method = RequestMethod.GET)
	public ResponseEntity<List<Genres>> getCondition(@PathVariable("conVar") String condition) {
		//calls method in GenreServices to return a list of data for a specific condition
		List<Genres> Weathercondition = genreService.getCondition(condition);
		return new ResponseEntity<List<Genres>>(Weathercondition, HttpStatus.OK);
	 }

}