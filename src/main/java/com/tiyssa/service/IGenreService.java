package com.tiyssa.service;

import java.util.List;

import com.tiyssa.entity.Genres;

public interface IGenreService {
     List<Genres> getAllGenres();
     Genres getTableId(int table_id);
     
     
//     boolean addEmployee(Genre employee);
//     void updateEmployee(Genre employee);
//     void deleteEmployee(int employee_id);
}