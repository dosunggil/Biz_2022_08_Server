package com.callor.todo.persistance;

import com.callor.todo.model.TodoVO;

public interface TodoDao extends GenericDao<TodoVO, Long> {
	public void create_todo_table();
	public int insertTodo(String todo);
	public void done(Long seq);
	public int updateTodo(String todo, Long seq);
}
