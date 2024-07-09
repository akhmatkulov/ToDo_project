package service;

import model.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ToDoService {

    List<ToDo> todos = new ArrayList<>();

    public List<ToDo> getTodoByUserId(UUID userId){
        List<ToDo> todos1 = new ArrayList<>();
        for(ToDo todo: todos){
            if(todo.getUserId().equals(userId)){
                todos1.add(todo);
            }
        }
        return todos1;
    }
}
