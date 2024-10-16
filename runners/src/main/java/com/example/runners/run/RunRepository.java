package com.example.runners.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository //By making this annotation, it is now part of the context of my application
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    @PostConstruct //initialization of this Class
    private void init(){
        runs.add(new Run(1, 
                        "My first run",
                        LocalDateTime.now(), 
                        LocalDateTime.now().plus(15, ChronoUnit.MINUTES),
                        3, 
                        Location.OUTDOOR));
        runs.add(new Run(2, 
                        "My second run",
                        LocalDateTime.now(), 
                        LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                        3, 
                        Location.OUTDOOR));
    }

    Run findById(int id){
        return runs.stream()
                        .filter(run -> run.id() == id)
                        .findFirst()
                        .get();
    }
}
