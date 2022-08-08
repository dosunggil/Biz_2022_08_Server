package com.callor.todo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("todoV1")
public class TodoServiceImplV1 implements TodoService{

	private TodoDao todoDao;
	
	
	public TodoServiceImplV1(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

	@Autowired
	@Override
	public void create_todo_table() {
		todoDao.create_todo_table();
			
	}

	@Override
	public int insertTodo(String todo) {
Date curDate = new Date(System.currentTimeMillis());
		
		// Date 객체의 값을 날짜, 시각 문자열 타입으로 변경하기 위한
		// 객체 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
		// 현재 날짜, 시각에 해당하는 문자열 생성하기
		// SimpleDateFormat 에 의해서 패턴대로 날짜 시각 문자열을 만든다.
		String sdate = dateFormat.format(curDate);
		String stime = timeFormat.format(curDate);
		
		TodoVO todoVO = TodoVO.builder()
							.todo(todo)
							.sdate(sdate)
							.stime(stime)
							.done(0).					
							build();
		return todoDao.insert(todoVO);
	
	}

	@Override
	public List<TodoVO> selectAll() {
		
		return todoDao.selectAll();
	}

	@Override
	public TodoVO findById(Long id) {
		return todoDao.findById(id);
	}

	@Override
	public int insert(TodoVO vo) {
		
		return 0;
	}

	@Override
	public int update(TodoVO vo) {
		
		return todoDao.update(vo);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void done(Long seq) {

		TodoVO todoVO = findById(seq);
		log.debug("여기입니다" + todoVO.toString());
Date curDate = new Date(System.currentTimeMillis());
		
		// Date 객체의 값을 날짜, 시각 문자열 타입으로 변경하기 위한
		// 객체 생성
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
		// 현재 날짜, 시각에 해당하는 문자열 생성하기
		// SimpleDateFormat 에 의해서 패턴대로 날짜 시각 문자열을 만든다.
		String date = dateFormat.format(curDate);
		String time = timeFormat.format(curDate);
		if(todoVO.getDone() ==0) {
			todoVO.setDone(1);
			todoVO.setEdate(date);
			todoVO.setEtime(time);
			update(todoVO);
		} else {
			todoVO.setDone(0);
			todoVO.setEdate(null);
			todoVO.setEtime(null);
			update(todoVO);
		}
	}

	@Override
	public int updateTodo(String todo, Long seq) {
		TodoVO todoVO = findById(seq);
		Date curDate = new Date(System.currentTimeMillis());
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
		String date = dateFormat.format(curDate);
		String time = timeFormat.format(curDate);
		
			todoVO.setTodo(todo);
			todoVO.setSdate(date);
			todoVO.setStime(time);
		return 	update(todoVO);
	
	}

}
