package com.example.runners.run;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController // it means im expecting a json in return 
//the above annotation is saying, im a class that response to requests and give responses

@RequestMapping("/api/runs")
public class RunController {

    // the runs in the system are going to be in memory first, then i can interact with them
    // instead of putting a list in the controller, ill delegate those operations to a new class
    // itll be at RunRepository.java
    /* 
    @GetMapping("/hello") //add behavior to methods and classes
    String home(){
        return "Hello, Runners";
    }
    */

    private final RunRepository runRepository;

    //wrong way:
    // public RunController() {
    //  this.runRepository = new Runrepository(); 
    //} this is wrong because anytime im creating a new instance of a class
    // is spring already has created an instance
    // ill only have one controller. it'll be a singleton

    // here is where dependencies injection comes into play
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository; // this runRepository is implied because of the annotation @Repository in RunRepository Class
    }
    
    @GetMapping("") // @GetMapping("/api/runs") this will be directed by the @RequestMapping
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        return runRepository.findById(id);
    }
    
    
}
