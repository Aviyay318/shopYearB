package org.example.shopyearb.Controller;


import org.example.shopyearb.DataBase.DBManager;
import org.example.shopyearb.Entity.MentorApplication;
import org.example.shopyearb.Response.MentorResponse;
import org.example.shopyearb.Response.RegisterResponse;
import org.example.shopyearb.Services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MentorController {

    @Autowired
    private DBManager dbManager;

    private Map<String,MentorApplication> applications  = new HashMap<>();

    private MentorService mentorService;


    @PostMapping("/application")
    public MentorResponse application(@RequestBody MentorApplication mentorApplication){
        boolean accepted = this.mentorService.apply(mentorApplication);
        mentorApplication.setAccepted(accepted);
        //db
        //  this.dbManager.addApplyMentor(mentorApplication);
        //map
        applications.put(mentorApplication.getEmail(), mentorApplication);



        MentorResponse mentorResponse = new MentorResponse(accepted);
        return mentorResponse;
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody String email){
        boolean successes = false;
        //Map
        if (this.applications.containsKey(email)){
            MentorApplication mentor = this.applications.get(email);
        //    this.dbManager.addMentor(mentor.getEmail(),mentor.getName(),mentor.getCity());
            successes = true;
        }
        //DB

      //  MentorApplication mentor = this.dbManager.getApplyMentorByEmail(email);
       // if (mentor!=null&&mentor.isAccepted()){
       //   this.dbManager.addMentor(mentor.getEmail(),mentor.getName(),mentor.getCity());
          successes = true;
      //  }

        return new RegisterResponse(successes);
    }







}
