package org.example.shopyearb.DataBase;

import jakarta.annotation.PostConstruct;
import org.example.shopyearb.Entity.Course;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/college";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    private Connection connection;

    @PostConstruct
    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("DB connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean isCourseExist(int courseId){
        boolean isCourseExist = false;
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        try(PreparedStatement ps = this.connection.prepareStatement(sql)){
            ps.setInt(1,courseId);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                isCourseExist = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isCourseExist;
    }

public boolean addCourse(Course course){
        boolean successes = true;
        String sql = "INSERT INTO courses(course_id,course_name) VALUES(?, ?)";
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(sql)){
            preparedStatement.setInt(1,course.getCourseId());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            successes = false;
            e.printStackTrace();
        }
        return successes;
}

public List<Course> getAllCourses(){
    List<Course> courses = new ArrayList<>();
        String sql ="SELECT * FROM courses";
        try(PreparedStatement ps = this.connection.prepareStatement(sql)){
           ResultSet resultSet = ps.executeQuery();
           while (resultSet.next()){
               Course course = new Course(resultSet.getInt("course_id"), resultSet.getString("course_name"));
               courses.add(course);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
return courses;
}


public int getStudentCourseCount(String id){
        int size = 0;
      String sql = "SELECT COUNT(*) FROM student_courses WHERE student_id = ?";
      try(PreparedStatement ps= this.connection.prepareStatement(sql)){
          ps.setString(1,id);
          ResultSet resultSet = ps.executeQuery();
          if (resultSet.next()){
             size = resultSet.getInt(1);
          }
      }catch (SQLException e){
          e.printStackTrace();
      }
      return size;
}
}
