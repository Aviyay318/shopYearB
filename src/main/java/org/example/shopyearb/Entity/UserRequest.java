package org.example.shopyearb.Entity;

import java.util.List;

public class UserRequest {
private int age;
private String name;
private List<String> flavors;
private String userChocolate;
private int dayesOfIceCream;
private boolean isLikesIceCream;


    public UserRequest(int age, String name, List<String> flavors, String userChocolate, int dayesOfIceCream, boolean isLikesIceCream) {
        this.age = age;
        this.name = name;
        this.flavors = flavors;
        this.userChocolate = userChocolate;
        this.dayesOfIceCream = dayesOfIceCream;
        this.isLikesIceCream = isLikesIceCream;
    }
    public UserRequest(){}


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFlavors() {
        return flavors;
    }

    public void setFlavors(List<String> flavors) {
        this.flavors = flavors;
    }

    public String getUserChocolate() {
        return userChocolate;
    }

    public void setUserChocolate(String userChocolate) {
        this.userChocolate = userChocolate;
    }

    public int getDayesOfIceCream() {
        return dayesOfIceCream;
    }

    public void setDayesOfIceCream(int dayesOfIceCream) {
        this.dayesOfIceCream = dayesOfIceCream;
    }

    public boolean isLikesIceCream() {
        return isLikesIceCream;
    }

    public void setLikesIceCream(boolean likesIceCream) {
        isLikesIceCream = likesIceCream;
    }


}
