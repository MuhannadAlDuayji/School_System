package com.system.school.business.administrator;

public class AdministratorQuery {

    public static String ADD_SCHOOL = "INSERT " +
            " INTO" +
            " SCHOOL (SCHOOL_NAME, ADD_BY_ID , ADD_AT) " +
            " VALUES (?,?,?)";

    public static String MOD_EXISTS_SCHOOL = "INSERT " +
            " INTO" +
            " SCHOOL (SCHOOL_NAME, MOD_BY_ID , MOD_AT) " +
            " VALUES (?,?,?)" +
            " WHERE " +
            " ID = ? " ;

    public static String GET_SCHOOL = "SELECT " +
            " ID " +
            " ,SCHOOL_NAME " +
            " ,ADD_BY_ID " +
            " ,ADD_AT "+
            " ,MOD_BY_ID " +
            " ,MOD_AT "+
            " FROM " +
            " SCHOOL WHERE " +
            " ID = ? ";

    public static String DELETE_SCHOOL = "DELETE " +
            " FROM " +
            " SCHOOL " +
            " WHERE " +
            " ID = ? ";

    public static String ADD_CLASSROOM = "INSERT" +
            " INTO" +
            " CLASSROOM (CLASS_NAME, SCHOOL_ID, ADD_BY_ID, ADD_AT) " +
            " VALUES (?,?,?,?)";

    public static String GET_CLASSROOM = "SELECT * " +
            " FROM" +
            " CLASSROOM " +
            " WHERE ID = ?";

    public static String DELETE_CLASSROOM = "DELETE " +
            " FROM " +
            " CLASSROOM" +
            " WHERE ID = ? ";

    public static String ADD_STUDENT = "INSERT " +
            " INTO " +
            " STUDENT (FIRST_NAME, LAST_NAME, EMAIL) " +
            " VALUES (?,?,?)";

    public static String GET_SCHOOL_TEST = "SELECT " +
            " ID " +
            " ,SCHOOL_NAME " +
            " ,ADD_BY_ID " +
            " ,ADD_AT "+
            " ,MOD_BY_ID " +
            " ,MOD_AT "+
            " FROM " +
            " SCHOOL WHERE " +
            " ID = 1 ";

    public static String DELETE_STUDENT = "DELETE " +
            " FROM" +
            " SCHOOL WHERE " +
            " SCHOOL_NAME = ? ";

    public static String ADD_TEST = "INSERT " +
            " INTO" +
            " TEMP_DATA_REGISTER (FIRST_NAME, LAST_NAME, DOB, PHONE, ID_PARENT, CREATED_AT, CREATED_BY) " +
            " VALUES (?,?,?,?,?,?,?)";
    public static String GET_TEST = "SELECT  " +
            " ID " +
            " ,FIRST_NAME " +
            " ,LAST_NAME "+
            " ,DOB "+
            " ,PHONE "+
            " ,ID_PARENT "+
            " ,CREATED_AT "+
            " ,CREATED_BY "+
            " FROM " +
            " TEMP_DATA_REGISTER ";

}
