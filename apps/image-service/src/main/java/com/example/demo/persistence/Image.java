package com.example.demo.persistence;

import javax.persistence.*;

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
