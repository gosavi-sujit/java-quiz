package com.demo.todo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.todo.dao.ToDoRepository;
import com.demo.todo.entity.ToDo;

@Service
@Component
@Transactional
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;
	
	@Override
	public ToDo createOrUpdate(ToDo todo) {
		return toDoRepository.save(todo);
	}

	@Override
	public ToDo read(Long id) {
		return toDoRepository.findById(id).orElse(null);
	}

	@Override
	public Boolean delete(Long id) {
		toDoRepository.deleteById(id);
		return Boolean.valueOf(true);
	}

	@Override
	public List<ToDo> findAll() {
		return toDoRepository.findAll();
	}

	@Override
	public Boolean deleteAllInBatch(List<ToDo> todos) {
		toDoRepository.deleteInBatch(todos);
		return Boolean.valueOf(true);
	}
	
}