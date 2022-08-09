package com.callor.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/todo")
public class TodoController {
	
	@Qualifier("todoV1")
	private TodoService todoService;
	
	public TodoController(@Qualifier("todoV1") TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String todo(Model model) {
		List<TodoVO> todoList = new ArrayList<TodoVO>();
				todoList = todoService.selectAll();
				model.addAttribute("TODOLIST",todoList);
		return null;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public String todo(String todo) {
		todoService.insertTodo(todo);
		return "redirect:/todo/list";
	}
	
	@RequestMapping(value="/{seq}/done", method=RequestMethod.GET)
	public String done(@PathVariable("seq") long seq) {
		
		todoService.done(seq);
		return "redirect:/todo/list";
	}
	@RequestMapping(value="/{seq}/edit", method=RequestMethod.GET)
	public String edit(@PathVariable("seq") long seq, Model model) {
		TodoVO todoVO = todoService.findById(seq);
		model.addAttribute("todoone",todoVO);
		List<TodoVO> todoList = new ArrayList<TodoVO>();
		todoList = todoService.selectAll();
		model.addAttribute("TODOLIST",todoList);
		
		return "todo/list";
	}
	@RequestMapping(value="/{seq}/edit", method=RequestMethod.POST)
	public String edit(@PathVariable("seq") long seq, String todo) {
		todoService.updateTodo(todo, seq);
		return "redirect:/todo/list";
	}
}
