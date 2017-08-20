package com.example.rafael.desafiotokenlab.domain;

/**
 * Created by rafael on 17/08/17.
 */

public class Game {

    private String name;
    private String release_date;
    private String[] platforms;
    private String image;

    public Game (){}

    public Game (String name,String release_date){
        this.name = name;
        this.release_date = release_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
