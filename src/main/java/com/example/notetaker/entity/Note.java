package com.example.notetaker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Random;

@Entity
public class Note {
    @Id
    private int id;
    private  String tittle;
    private String content;
    private Date createdDate;


    public Note() {
    }

    public Note( String tittle, String content, Date createdDate) {
        this.id = new Random().nextInt(99999);
        this.tittle = tittle;
        this.content = content;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
