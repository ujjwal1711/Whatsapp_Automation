package com.clicdirectory.entity;

/**
 * Created by hackme on 12/9/18.
 */
public class Post {
    public Post(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getUn_likes() {
        return un_likes;
    }

    public void setUn_likes(Long un_likes) {
        this.un_likes = un_likes;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public Long getShare() {
        return share;
    }

    public void setShare(Long share) {
        this.share = share;
    }

    public String title;
    public String url;
    public String embedCode;

    public String getEmbedCode() {
        return embedCode;
    }

    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }

    public String description;
    public String author_name;
    public String posted_date;
    public Long likes;
    public Long un_likes;
    public Long comments;
    public Long share;

    /*

var x = {"title":document.querySelector("#info-contents h1").textContent,"description":document.querySelector("#description").textContent.trim(),"author_name":document.querySelector("#owner-container").textContent.trim(),"posted_date":"","likes":408,"un_likes":0,"comments":408,"share":408,"url":window.location.href};
JSON.stringify(x);

    * */
}
