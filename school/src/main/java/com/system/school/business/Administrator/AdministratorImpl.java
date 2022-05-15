package com.system.school.business.Administrator;

import com.system.school.business.Administrator.rm.SchoolRowMapper;
import com.system.school.business.Administrator.rm.StudentRowMapper;
import com.system.school.business.Administrator.rm.TestRM;
import com.system.school.model.school.ClassRoom;
import com.system.school.model.school.Record;
import com.system.school.model.school.StudentRegistration;
import com.system.school.model.user.User;
import com.system.school.model.school.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AdministratorImpl implements IAdministrator{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SchoolRowMapper schoolRowMapper = new SchoolRowMapper();

    // School functions
    @Override
    public int addSchool(School school) {

        if (school.getId() == 0){

            return jdbcTemplate.update(AdministratorQuery.ADD_SCHOOL , new Object[]{school.getSchoolName(),
                "Muhannad", LocalDateTime.now()});
        }else
            return jdbcTemplate.update(AdministratorQuery.MOD_EXISTS_SCHOOL ,new Object[]{school.getSchoolName(),
                "Yasser",LocalDateTime.now(),school.getId()});
    }

    @Override
    public School getSchool(int id){

        Object [] params = new Object[]{id};
        log.debug("params ... "+params.length+" contain : "+params.toString()  );
        List<School> temp = jdbcTemplate.query(AdministratorQuery.GET_SCHOOL,schoolRowMapper,params);
        log.debug("Temp data from JDBC Size "+temp.size());

        return temp.get(0);
    }

    public List<School> getSchools(){

        Object [] params = new Object[]{new Integer(0)};
        String inject = " OR 1=1 ";
        log.debug("params ... "+params.length+" contain : "+params.toString()  );
        List<School> temp = jdbcTemplate.query(AdministratorQuery.GET_SCHOOL+inject,schoolRowMapper,params);
        log.debug("Temp data from JDBC Size "+temp.size());
        return temp;
    }

    @Override
    public int deleteSchool(int id) {
        return jdbcTemplate.update(AdministratorQuery.DELETE_SCHOOL
                ,new Object[]{new Integer(id)});
    }

    @Override
    public int addClassRoom(int id, int schoolId, ClassRoom classRoom) {
        return jdbcTemplate.update(AdministratorQuery.ADD_CLASSROOM, new Object[]{classRoom.getClassName() ,new Integer(schoolId),"Muhannad",new Date()});
    }

    @Override
    public List<ClassRoom> getClassRooms(int classroomId) {
        return null;
    }

    @Override
    public int deleteClassRoom(int id, int schoolId) {
        return 0;
    }

    @Override
    public int addStudent(int id, User studentId, int classRoom, int school) {
        return 0;
    }
    @Override
    public User getStudent(int id) {

        Object params = new Object[]{new Integer(id)};
        User student =  jdbcTemplate.query("",new StudentRowMapper(),params).get(0);
        return student;
    }
    @Override
    public List<User> getStudents(){

        Object params = new Object[]{new Integer(0)};
        List<User> students =  jdbcTemplate.query("",new StudentRowMapper(),params);
        return students;

    }
    @Override
    public int deleteStudent(int id, int studentId, int school) {
        return 0;
    }
    @Override
    public int addToTempRegistration(StudentRegistration studentRegistration) {

        return jdbcTemplate.update(AdministratorQuery.ADD_TEST
                ,studentRegistration.getFirstName()
                ,studentRegistration.getLastName()
                ,studentRegistration.getDOB()
                ,studentRegistration.getPhone()
                ,studentRegistration.getIdParent()
                ,studentRegistration.getCreatedAt()
                ,studentRegistration.getCreatedBy());

    }

    @Override
    public List<StudentRegistration> getStudentTempRegistration() {

        log.debug(" has been logged ... getStudentTempRegistration()");
        List<StudentRegistration>  test = null;
        try {
            test = jdbcTemplate.query(AdministratorQuery.GET_TEST , new TestRM());
        }catch (DataAccessException e){
            log.debug("DataAccessException "+e);
        }catch (Exception e){
            log.debug(" error happen from DAO..."+e.getStackTrace());
        }

        return test;
    }

    @Override
    public int addRecord() {

        jdbcTemplate.ex

        return 0;
    }

    @Override
    public Record getRecord() {
        return null;
    }

    @Override
    public List<Record> getRecords() {
        return null;
    }

    @Override
    public int deleteRecord() {
        return 0;
    }

    @Override
    public int addRecordComponent() {
        return 0;
    }

    @Override
    public Record getRecordComponent() {
        return null;
    }

    @Override
    public List<Record> getRecordsComponent() {
        return null;
    }

    @Override
    public int deleteRecordComponent() {
        return 0;
    }

}
