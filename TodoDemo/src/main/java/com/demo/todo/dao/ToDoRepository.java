package com.demo.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.todo.entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long>{
}