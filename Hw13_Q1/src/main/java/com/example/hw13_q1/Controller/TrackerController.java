package com.example.hw13_q1.Controller;

import com.example.hw13_q1.Model.TrackerSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/trackersystem")
public class TrackerController {
    ArrayList<TrackerSystem> tasks=new ArrayList<>();

    @GetMapping("/get")
    public  ArrayList<TrackerSystem> getTodo(){
        return tasks;
    }

    @PostMapping("/add")
    public String addTrackerSystem(@RequestBody TrackerSystem trackersystem){
        tasks.add(trackersystem);
        return "TrackerSystem added!";
    }

    //update - Put
    @PutMapping("/update/{index}")
    public String updateTrackerSystem(@PathVariable int index , @RequestBody TrackerSystem trackersystem){
        tasks.set(index, trackersystem);
        return "TrackerSystem updated!";
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public String deleteTrackerSystem(@PathVariable int index){
        tasks.remove(index);
        return "TrackerSystem deleted!";
    }

    @PutMapping("/status/{index}/{status}")
    public String updateCustomerStatus(@PathVariable int index ,@PathVariable int status){

        TrackerSystem trackerSystem = tasks.get(index);
        trackerSystem.setStatus(status == 1 ? "DONE" :"NOT DONE");

        tasks.set(index, trackerSystem);
        return "customers updated!";
    }

    @GetMapping("/serech{title}")
    public String serech(@PathVariable String title){
        System.out.println(tasks);
        for(TrackerSystem t:tasks){
            System.out.println("found");
            if (t.getTitle().equals(title)){
                System.out.println(t);
                return t.getTitle();
            }
        }
        return "not found";
    }


}

