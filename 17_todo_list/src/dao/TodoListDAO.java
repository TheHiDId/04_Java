package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Todo;

public class TodoListDAO {
	private final String File_Path = "TodoList.bin";
	
	private List<Todo> todoList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	//
	public TodoListDAO() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(File_Path);
		
		if(!file.exists()) {
			todoList = new ArrayList<Todo>();
			
		} else {
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				
				todoList = (List<Todo>)ois.readObject();
				
			} finally {
				
				if(ois != null) ois.close();
			}
		}
	}
	
	//
	public void saveFile() throws FileNotFoundException, IOException {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(File_Path));
			
			oos.writeObject(todoList);
			
		} finally {
			
			if(oos != null) oos.close();
		}
	}
	
	//
	public List<Todo> todoListFullView() {
		return todoList;
	}
	
	//
	public int todoAdd(Todo todo) throws FileNotFoundException, IOException {
		todoList.add(todo);
		
		saveFile();
		
		return todoList.indexOf(todo);
	}
	
	//
	public boolean todoComplete(int index) throws FileNotFoundException, IOException {
		if(todoList.get(index) == null) return false;
		
		if(todoList.get(index).isComplete()) {
			todoList.get(index).setComplete(false);
		} else {
			todoList.get(index).setComplete(true);
		}
		
		saveFile();
		
		return true;
	}
}
