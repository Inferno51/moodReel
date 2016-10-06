package com.tiyssa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
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
	public ResponseEntity<Genres> getGenreById(@PathVariable("id") Integer id) {
		Genres genre = genreService.getGenreById(id);
		return new ResponseEntity<Genres>(genre, HttpStatus.OK);
	}

	@RequestMapping(value= "/genre", method = RequestMethod.GET)
	public ResponseEntity<List<Genres>> getAllGenres() {
		List<Genres> genres = genreService.getAllGenres();
		return new ResponseEntity<List<Genres>>(genres, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/condition", method = RequestMethod.GET)
	public ResponseEntity<List<Genres>> getConditionStatus() {
		List<Genres> condition = genreService.getConditionStatus();
		return new ResponseEntity<List<Genres>>(condition, HttpStatus.OK);
	}

	/*@RequestMapping(value= "/employee", method = RequestMethod.POST)
	public ResponseEntity<Void> employeePerson(@RequestBody Employee employee, UriComponentsBuilder builder) {
        boolean flag = employeeService.addEmployee(employee);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employee.getEmployeeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}*/
	/*@RequestMapping(value="/employee/{id}", method = RequestMethod.PUT )
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}*/
	/*@RequestMapping(value="/employee/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> Employee(@PathVariable("id") Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	*/
} 