package com.cb.bl;


public class CharacterBL {

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

    public String getCharname() {
        return charname;
    }

    public void setCharname(String name) {
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
