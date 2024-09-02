package com.bhs.examples.springtutorial;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController
//public class Controller {
//    @GetMapping("/todo/{id}")
//    public String getTodoById(@PathVariable("id") String id) throws IOException{
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url("https://jsonplaceholder.typicode.com/todos/"+id).build();
//        try(Response response = client.newCall(request).execute()){
//            return response.body().string();
//        }
//    }
//}

@RestController
public class Controller{
    List<Todo> todoList;
    public Controller(){
        todoList = new ArrayList<Todo>();
        todoList.add(new Todo(1,1,"Learning Spring",false));
        todoList.add(new Todo(2,1,"Learning React",true));
    }
    @GetMapping("/todos")
    public List<Todo> getTodoList(){
        return todoList;
    }
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id){
        for(Todo t : todoList){
            if(t.getId() == id){return t;}
        }
        return null;
    }
    @PostMapping("/todos")
    public Todo addNewTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
        return newTodo;
    }
}
