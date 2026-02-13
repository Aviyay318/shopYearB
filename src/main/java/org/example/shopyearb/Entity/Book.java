package org.example.shopyearb.Entity;

public class Book {
    private int id;
    private String name;
    private int length;
    private String genre;
    private int cost;
    private String authorId;


    public Book(){}

    public Book(int id, String name, int length, String genre, int cost, String authorId) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.genre = genre;
        this.cost = cost;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
