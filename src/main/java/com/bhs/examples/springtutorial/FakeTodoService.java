package com.bhs.examples.springtutorial;


import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements ITodoService{
    @TimeMonitor
    public void run(){
        for(int i=0;i<1000000000;i++){}
        System.out.println("Fake Todo Service");
    }
}
