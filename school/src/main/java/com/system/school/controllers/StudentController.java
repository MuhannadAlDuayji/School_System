package com.system.school.controllers;


import com.system.school.business.student.IStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudent iStudent;

    @GetMapping("/v1")
    public String get(){
        return "data...";
    }

    @GetMapping("/getSchool/{id}")
    public ModelMap getSchool(@PathVariable int id){

        log.debug("getSchool() called from user ****er ...");
        Map<String,Object> data = new HashMap<>();
        data.put("school",iStudent.getSchool(id));
        log.debug("data will send to user ****er ...");
        data.keySet().stream().forEach(s -> log.debug(s));
        log.debug("getSchool() will return from successfully ****er ...");
        return new ModelMap().addAttribute("data",data)
                .addAttribute("successes",true);
    }

    @GetMapping("/getClassroom")
    public ModelMap getClassRoom(){

        log.debug("getClassRoom() called from user ****er ...");
        Map<String,Object> data = new HashMap<>();
        data.put("classRoom",iStudent.getClassRoom(1,1));
        log.debug("data will send to user ****er ...");
        data.keySet().stream().forEach(s -> log.debug(s));
        log.debug("getClassRoom() will return from successfully ****er ...");
        return new ModelMap().addAttribute("data",data)
                .addAttribute("successes",true);

    }

    @GetMapping("/getRecord")
    public ModelMap getRecord(){

        log.debug("getRecord() called from user ****er ...");
        Map<String,Object> data = new HashMap<>();
        data.put("record",iStudent.getRecord(1,1));
        log.debug("data will send to user ****er ...");
        data.keySet().stream().forEach(s -> log.debug(s));
        log.debug("getRecord() will return from successfully ****er ...");
        return new ModelMap().addAttribute("data",data)
                .addAttribute("successes",true);
    }

    @GetMapping("/getRecordComponent")
    public ModelMap getRecordComponent(){

        log.debug("getRecordComponent() called from user ****er ...");
        Map<String,Object> data = new HashMap<>();
        data.put("recordComponent",iStudent.getRecordComponent(1,2,4));
        log.debug("data will send to user ****er ...");
        data.keySet().stream().forEach(s -> log.debug(s));
        log.debug("getRecord() will return from successfully ****er ...");
        return new ModelMap().addAttribute("data",data)
                .addAttribute("successes",true);
    }
}
