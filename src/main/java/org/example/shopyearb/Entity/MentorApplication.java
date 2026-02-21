package org.example.shopyearb.Entity;

import java.util.List;

public class MentorApplication {
    private String name;
    private String email;
    private int yearsExperience;
    private boolean manegedTeam;
    private List<String> userTechnology;
    private String city;
    private int hourFrontal;
    private int hourOnline;
    private boolean isAccepted;

    public MentorApplication(){}

    public MentorApplication(String name, String email, int yearsExperience, boolean manegedTeam, List<String> userTechnology, String city, int hourFrontal, int hourOnline) {
        this.name = name;
        this.email = email;
        this.yearsExperience = yearsExperience;
        this.manegedTeam = manegedTeam;
        this.userTechnology = userTechnology;
        this.city = city;
        this.hourFrontal = hourFrontal;
        this.hourOnline = hourOnline;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public boolean isManegedTeam() {
        return manegedTeam;
    }

    public void setManegedTeam(boolean manegedTeam) {
        this.manegedTeam = manegedTeam;
    }

    public List<String> getUserTechnology() {
        return userTechnology;
    }

    public void setUserTechnology(List<String> userTechnology) {
        this.userTechnology = userTechnology;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHourFrontal() {
        return hourFrontal;
    }

    public void setHourFrontal(int hourFrontal) {
        this.hourFrontal = hourFrontal;
    }

    public int getHourOnline() {
        return hourOnline;
    }

    public void setHourOnline(int hourOnline) {
        this.hourOnline = hourOnline;
    }
}
