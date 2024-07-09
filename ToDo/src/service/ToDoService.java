package service;

import model.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ToDoService {

    List<ToDo> todos = new ArrayList<>();

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
