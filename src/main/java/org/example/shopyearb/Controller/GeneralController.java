package org.example.shopyearb.Controller;

import org.example.shopyearb.DataBase.DBUtils;
import org.example.shopyearb.Entity.Course;
import org.example.shopyearb.Response.BasicResponse;
import org.example.shopyearb.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeneralController {

    @Autowired
    DBUtils dbUtils;




    @PostMapping("/add-course")
    public BasicResponse addCourse(@RequestBody Course course){
        boolean successes = false;
        Integer errorCode = Constant.COURSE_EXIST;
       if (course!=null){
           if (!this.dbUtils.isCourseExist(course.getCourseId())){
               if (this.dbUtils.addCourse(course)){
                   successes = true;
                   errorCode = null;
               }
           }
       }
       return new BasicResponse(successes,errorCode);
    }
    //http://localhost:8080/get-all-courses

    @GetMapping("/get-all-courses")
    public List<Course> getAllCourses(){
        return this.dbUtils.getAllCourses();
    }
}
