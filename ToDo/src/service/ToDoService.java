package service;

import model.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ToDoService {

    private final List<ToDo> todos = new ArrayList<>();

    public void add(ToDo toDo) {
        if (!has(toDo)) {
            todos.add(toDo);
        }
    }

    private boolean has(ToDo toDo) {
        for (ToDo toDo1: todos) {
            if (toDo1.getName().equals(toDo.getName())) {
                return true;
            }
        }
        return false;
    }

    public void complete(UUID toDoId) {
        for (ToDo toDo: todos) {
            if (toDo.getId().equals(toDoId)) {
                toDo.setComplete(true);
            }
        }
    }

    public ToDo addTodo(ToDo toDo) {
        if (hasTodo(toDo.getName())) {
            return null;
        }
        todos.add(toDo);
        return toDo;
    }

    private boolean hasTodo(String name) {
        for (ToDo toDo : todos) {
            if (toDo != null) {
                if (toDo.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }


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
