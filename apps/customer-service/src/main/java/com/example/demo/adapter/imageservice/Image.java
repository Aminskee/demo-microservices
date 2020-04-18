package com.example.demo.adapter.imageservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private  String image;

    protected Image(){
    }
    public Image(String image){
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", image='" + image + '\'' +
                '}';
    }
}
