package com.bhs.examples.springtutorial;

import org.springframework.stereotype.Service;

@Service("todoService")
public class TodoService implements ITodoService{
    @TimeMonitor
    public void run(){
        for(int i = 0;i<10000000;i++){}
        System.out.println("Todo Service");
    }
}
