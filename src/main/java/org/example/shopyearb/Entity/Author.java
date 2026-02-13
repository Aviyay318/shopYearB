package org.example.shopyearb.Entity;

public class Author {
    private String name;
    private String id;
    private String password;
    private String token;

    public Author(){}

    public Author(String name, String id, String password,String token) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
