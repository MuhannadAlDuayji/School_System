package com.system.school;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.github.javafaker.Faker;
import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.School;
import com.system.school.model.school.StudentRegistration;
import com.system.school.model.user.User;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class TestFake {

    static Faker  faker = new Faker();
    static SimpleDateFormat desiredFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) throws JsonProcessingException {
        Faker faker = new Faker();
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.setFirstName(faker.programmingLanguage().name());
        studentRegistration.setLastName(faker.leagueOfLegends().champion());
        studentRegistration.setDOB(Date.from(Instant.now()));
        studentRegistration.setCreatedAt(Date.from(Instant.now()));
        studentRegistration.setCreatedBy("Online Req");
        studentRegistration.setPhone(faker.phoneNumber().phoneNumber());

        ObjectMapper s = JsonMapper.builder()
                .addModule(new ParameterNamesModule())
                .addModule(new Jdk8Module())
                .addModule(new JavaTimeModule()).build();


        String temp = s.writeValueAsString(studentRegistration);

        System.out.println(temp);
        System.out.println(studentRegistration.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        String tempSchool = s.writeValueAsString(school());
        System.out.println(tempSchool);
        System.out.println("======================================");
        System.out.println(s.writeValueAsString(school()));
        System.out.println("======================================");
        String result = desiredFormat.format(Date.from(Instant.now()));
        System.out.println(result);
        Boolean aBoolean = new Boolean("") ;
        System.out.println(aBoolean);
        System.out.println(s.writeValueAsString(classRoom()));

        System.out.println("+966 5"+faker.number().digits(1)+" "+faker.number().digits(3)
                +" "+faker.number().digits(4));

    }

    public static School school(){



        School school = new School();

        school.setSchoolName(faker.university().name());


        school.setAddedAt(desiredFormat.format(faker.date().birthday()));

        return school;
    }

    public static ClassRoom classRoom(){

        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassName(faker.programmingLanguage().name());

        System.out.println("===================================");

        return classRoom;
    }
}
