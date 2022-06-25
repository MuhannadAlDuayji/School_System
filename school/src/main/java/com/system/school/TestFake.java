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
import com.sun.nio.zipfs.ZipFileStore;
import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.School;
import com.system.school.model.school.StudentRegistration;
import com.system.school.model.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
@PropertySource({"C:/Application/School_prop/jdbcTest.properties"})

public class TestFake {

    static Faker  faker = new Faker();
    public static void main(String[] args) throws JsonProcessingException {

        File aaa = new File("C:/Application/School_prop/jdbcTest.properties");
        System.out.println(aaa.exists());

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

        Boolean aBoolean = new Boolean("") ;
        System.out.println(aBoolean);
        System.out.println(s.writeValueAsString(classRoom()));

        System.out.println("+966 5"+faker.number().digits(1)+" "+faker.number().digits(3)
                +" "+faker.number().digits(4));

    }

    public static School school(){



        School school = new School();

        school.setSchoolName(faker.university().name());
        school.setAddedAt(faker.date().birthday().toString());
        school.setManger(new User());

        return school;
    }

    public static ClassRoom classRoom(){

        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassName(faker.programmingLanguage().name());

        System.out.println("===================================");

        return classRoom;
    }
}
