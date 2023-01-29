package com.example.Pathfinder.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity{

    @Column(name = "date_time")
    private String dateTime;
//    private LocalDate dateTime;  //Accepts Date and Time values

    @Column(name = "text_content")
    private String textContent; //Accepts very long String values

    private User author;  //Accepts User Entities as values
    private User recipient;  //Accepts User Entities as value

    public Message() {
    }

    public String getDateTime() {
        return dateTime;
    }

    public Message setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    //    public LocalDate getDateTime() {
//        return dateTime;
//    }
//
//    public Message setDateTime(LocalDate dateTime) {
//        this.dateTime = dateTime;
//        return this;
//    }

    public String getTextContent() {
        return textContent;
    }

    public Message setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Message setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public User getRecipient() {
        return recipient;
    }

    public Message setRecipient(User recipient) {
        this.recipient = recipient;
        return this;
    }
}
