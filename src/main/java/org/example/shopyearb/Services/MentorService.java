package org.example.shopyearb.Services;

import org.example.shopyearb.Entity.MentorApplication;

public class MentorService {

    public boolean apply(MentorApplication mentorApplication){
        boolean isAccepted = false;
        int score = 0;

        if (mentorApplication.getYearsExperience()>=5){
            score+=15;
        }
        if (mentorApplication.isManegedTeam()){
            score+=15;
        }
        score+=mentorApplication.getUserTechnology().size() * 5;
        if (mentorApplication.getHourFrontal() + mentorApplication.getHourOnline()>=40){
            score = 0;
        }else {
            score+=mentorApplication.getHourFrontal() * 2;
            score+= mentorApplication.getHourOnline();
        }
        if (score>=75){
            isAccepted = true;
        }
        return isAccepted;

    }


//    על כל שעה פרונטלית יקבל 2 נק
//    על כל שעה אונליין יקבל נקודה אחת
//    יש לבדוק ולאמת שסך השעות השבועיות בסהכ לא עובר את 40 שעות – אם עובר המועמד לא אמין והבקשה תדחה

}
