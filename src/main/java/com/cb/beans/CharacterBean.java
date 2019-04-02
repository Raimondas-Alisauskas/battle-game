package com.cb.beans;

import java.sql.Blob;

public class CharacterBean {

    private int id;
    private String name;
    private Blob image;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Blob getImage() { return image; }

    public void setImage(Blob image) { this.image = image; }
}
