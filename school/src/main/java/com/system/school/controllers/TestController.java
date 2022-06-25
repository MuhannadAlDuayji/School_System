package com.system.school.controllers;

import com.system.school.business.administrator.IAdministrator;
import com.system.school.model.school.StudentRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/index")
public class TestController {

    @Autowired
    private IAdministrator administrator;

    @GetMapping(value = "/v1")
    public String index(){
        return "index";
    }


    @PostMapping(value = "/add")
    public String addIndex(@RequestBody StudentRegistration studentRegistration){
        String state = "Good Request";
        log.debug(studentRegistration.toString());
        try {
            administrator.addToTempRegistration(studentRegistration);
        }catch (Exception e){
            state = "error "+e;
        }
        return state;
    }

    @GetMapping(value = "/get")
    public List<StudentRegistration> getIndex(){
        List<StudentRegistration> studentRegistration = null;

        try {
            studentRegistration = administrator.getStudentTempRegistration();

        }catch (Exception e){
            log.debug("ERROR");
        }
        return studentRegistration;
    }
}
