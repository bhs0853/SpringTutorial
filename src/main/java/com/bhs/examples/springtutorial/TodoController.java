package com.bhs.examples.springtutorial;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("api/v1/todos")
public class TodoController {

    private final ITodoService todoService1;
    private final ITodoService todoService2;

    List<Todo> todoList;

    public TodoController(@Qualifier("todoService")ITodoService todoService1,
                          @Qualifier("fakeTodoService")ITodoService todoService2){
        todoList = new ArrayList<Todo>();
        todoList.add(new Todo(1,1,"Learning Spring",false));
        todoList.add(new Todo(2,1,"Learning React",true));
        this.todoService1 = todoService1;
        this.todoService2 = todoService2;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodoList(){
        todoService1.run();
        todoService2.run();
        return ResponseEntity.ok(todoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable("id") int id){
        for(Todo t : todoList){
            if(t.getId() == id){return ResponseEntity.ok(t);}
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Todo> addNewTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateTodo(@RequestBody Todo updateTodo){
        for(Todo t : todoList){
            if(t.getId() == updateTodo.getId()){
                if(updateTodo.isCompleted() != t.isCompleted()){
                    t.setCompleted(updateTodo.isCompleted());
                }    
                if(updateTodo.getTitle() != t.getTitle()){
                    t.setTitle(updateTodo.getTitle());
                }
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable("id") int id) {
        for (Todo t : todoList) {
            if (t.getId() == id) {
                todoList.remove(t);
                break;
            }
        }
        return ResponseEntity.ok().build();
    }
}
