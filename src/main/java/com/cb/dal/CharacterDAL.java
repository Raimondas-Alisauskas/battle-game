package com.cb.dal;


public class CharacterDAL {

    private int id;
    private String charname;
    private String imageReference;
    private int partyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return charname;
    }

    public void setName(String name) {
        this.charname = name;
    }

    public String getImageReference() {
        return imageReference;
    }

    public void setImageReference(String imageReference) {
        this.imageReference = imageReference;
    }

    public int getPartyId() { return partyId; }

    public void setPartyId(int partyId) { this.partyId = partyId; }
}
