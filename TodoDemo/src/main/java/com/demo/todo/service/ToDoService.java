package com.demo.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.todo.entity.ToDo;

@Service
public interface ToDoService {
	ToDo createOrUpdate(ToDo todo);
	ToDo read(Long id);
	Boolean delete(Long id);
	List<ToDo> findAll();
	Boolean deleteAllInBatch(List<ToDo> todos);
}
