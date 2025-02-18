package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.TodoListDAO;
import dto.Todo;

public class TodoListService {
	private TodoListDAO dao = null;
	
	// 기본 생성자
	public TodoListService() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new TodoListDAO();
	}
	
	//
	public Map<String, Object> todoListFullView() {
		List<Todo> todoList =  dao.todoListFullView();
		
		int completeCount = 0;
		
		for(Todo todo : todoList) {
			if(todo.isComplete()) {
				completeCount++;
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		return map;
	}
	
	//
	public String dateFormat(LocalDateTime regDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
    String formattedDateTime = regDate.format(formatter);
		
    return formattedDateTime;
	}
	
	//
	public String todoDetailView(int index) {
		Todo todo = dao.todoListFullView().get(index);
		
		if(todo == null) return null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		sb.append(String.format("제목: %s\n", todo.getTitle()));
		sb.append(String.format("등록일: %s\n", dateFormat(todo.getRegDate())));
		sb.append(String.format("완료 여부: %s\n", todo.isComplete() ? "O" : "X"));
		sb.append("[세부 내용]\n");
		sb.append(String.format("%s\n", todo.getDetail()));
		
		return sb.toString();
	}
	
	//
	public int todoAdd(String title, String detail) throws FileNotFoundException, IOException {
		Todo todo = new Todo(title, detail, false, LocalDateTime.now());
		
		return dao.todoAdd(todo);
	}
	
	//
	public boolean todoComplete(int index) throws FileNotFoundException, IOException {
		return dao.todoComplete(index);
	}
}
