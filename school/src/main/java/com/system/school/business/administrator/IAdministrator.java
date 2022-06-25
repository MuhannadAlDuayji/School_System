package com.system.school.business.administrator;

import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.Record;
import com.system.school.model.school.StudentRegistration;
import com.system.school.model.user.User;
import com.system.school.model.school.School;

import java.util.List;


public interface IAdministrator {

    // School functions
    public int addSchool(School school);
    public School getSchool(int id);
    public List<School> getSchools();
    public int deleteSchool(int id);

    // Classroom functions
    public int addClassRoom(int schoolId , ClassRoom classRoom);
    public List<ClassRoom> getClassRooms(int schoolId);
    public int deleteClassRoom(int id , int schoolId);

    // Student functions
    public int addStudent(int id , User studentId , int classRoom , int school);
    public User getStudent(int id);
    public List<User> getStudents();
    public int deleteStudent(int id, int studentId, int school);

    // test functions
    public int addToTempRegistration(StudentRegistration studentRegistration);
    public List<StudentRegistration> getStudentTempRegistration();

    // School functions
    public int addRecord();
    public Record getRecord();
    public List<Record> getRecords();
    public int deleteRecord();

    public int addRecordComponent();
    public Record getRecordComponent();
    public List<Record> getRecordsComponent();
    public int deleteRecordComponent();

}
