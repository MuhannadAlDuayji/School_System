package com.system.school.controllers;

import com.system.school.business.Administrator.IAdministrator;
import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Slf4j
@RestController
public class AdministratorController {

    private final IAdministrator administrator;

    public AdministratorController(IAdministrator administrator) {
        this.administrator = administrator;
    }

    @PostMapping("/addSchool")
    public String addSchool(@RequestBody School school){

        int i = 0;
        try {
            i = this.administrator.addSchool(school);
        }catch (Exception e){
            return "Sorry Error happen call IT Department +996 54354 "+e;
        }
        return i > 0 ? "Successfully Added ..." : "Sorry Error happen call IT Department +996 54354";
    }

    @GetMapping("/getSchool/{id}")
    public School getSchool(@PathVariable("id") int id){
        School school = null;
        try {
            log.debug("Hello Muhannad ... "+id);
            school = this.administrator.getSchool(id);
        }catch (Exception e){
            log.debug("Error happen ... "+e);
        }
        return school;
    }

    @DeleteMapping("/deleteSchool/{id}")
    public String deleteSchool(@PathVariable int id){

        log.debug("Delete School id = "+id);

        int state = 0;
        String response = "School dose not exist ...";
        try {
            state = this.administrator.deleteSchool(id);
            if (state > 0 ){
                response = "School id = "+ id +"deleted";
            }

        }catch (Exception e){
            response = "Error happen "+e;
        }

        log.debug("Message response => "+response);
        return response;
    }

    @PostMapping("/addClassRoom/{id}")
    public String addClassRoom(@RequestBody ClassRoom classRoom,@PathVariable int id){

        log.debug("Message for classroom : "+classRoom+" id = "+id);
        String response = "OK!!! ClassRoom Added to School ID = "+id;
        try {

            this.administrator.addClassRoom(0,id,classRoom);

        }catch (Exception e){
            response =": ERROE :"+e;
        }
        return response;
    }

    @GetMapping("/getClassRoom/{id}")
    public String getClassRoom(@PathVariable int id){

        log.debug("Get classroom id = "+id);
        String response = "OK!!! ClassRoom  to School ID = "+id;
        try {

            this.administrator.getClassRooms(id);

        }catch (Exception e){
            response =": ERROE :"+e;
        }
        return response;
    }

    @GetMapping("/")
    public String mapping() {
        log.debug("Hello Muhannad ... ");
        return "SpringBoot !!!";
    }

}
