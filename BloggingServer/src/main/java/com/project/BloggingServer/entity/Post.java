package com.project.BloggingServer.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer likeCount;
    private Integer viewCount;
    private Date date;

    // Manually add getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", likeCount=" + likeCount +
                ", viewCount=" + viewCount +
                ", date=" + date +
                '}';
    }

}
