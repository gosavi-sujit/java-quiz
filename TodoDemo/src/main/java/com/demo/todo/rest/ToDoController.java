package com.demo.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.todo.entity.ToDo;
import com.demo.todo.service.ToDoService;

@RestController
@CrossOrigin
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	/**
     * create a ToDo
     *
     * @param todo request body json of the todo to create 
     */
    @RequestMapping(value = "/demo/todo", method = RequestMethod.POST)
    public ToDo createTodo(@RequestBody ToDo todo) {
    	return toDoService.createOrUpdate(todo);
    }
    
    /**
     * update a ToDo
     *
     * @param todo request body json of the todo to update 
     */
    @RequestMapping(value = "/demo/todo", method = RequestMethod.PUT)
    public ToDo updateTodo(@RequestBody ToDo todo) {
    	return toDoService.createOrUpdate(todo);
    }
    
    /**
     * read a ToDo
     *
     * @param id of the todo to read 
     */
    @RequestMapping(value = "/demo/todo/{id}", method = RequestMethod.GET)
    public ToDo readTodo(@PathVariable Long id) {
    	return toDoService.read(id);
    }
    
    /**
     * read all ToDo's
     *
     */
    @RequestMapping(value = "/demo/readAll", method = RequestMethod.GET)
    public List<ToDo> readAll() {
    	return toDoService.findAll();
    }
    
    /**
     * delete a ToDo
     *
     * @param id of the todo to delete 
     */
    @RequestMapping(value = "/demo/todo/{id}", method = RequestMethod.DELETE)
    public Boolean deleteTodo(@PathVariable Long id) {
    	return toDoService.delete(id);
    }
    
    /**
     * delete a mulitple ToDo's
     *
     * @param list of id's of the todo to delete 
     */
    @RequestMapping(value = "/demo/deleteAll", method = RequestMethod.DELETE)
    public Boolean deleteAll(@RequestBody List<ToDo> todos) {
    	return toDoService.deleteAllInBatch(todos);
    }
}