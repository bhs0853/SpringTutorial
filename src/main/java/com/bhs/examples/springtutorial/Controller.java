package com.bhs.examples.springtutorial;

import okhttp3.*;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/todo/{id}")
    public String getTodoById(@PathVariable("id") String id) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://jsonplaceholder.typicode.com/todos/"+id).build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }
}
