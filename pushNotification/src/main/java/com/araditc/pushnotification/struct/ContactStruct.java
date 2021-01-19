package com.araditc.pushnotification.struct;

import com.araditc.pushnotification.consts.MessageTypes;

public class ContactStruct extends MessageTemplate{

    private int id;

    private String username;

    private String firstName;

    private String lastName;

    private String bio;

    private String role;

    private ImageStruct profileImage;


    public String getFullName() {
        String fullName = username;
        if (firstName != null && !firstName.equals("")) {
            fullName = firstName;
        }

        if (lastName != null && !lastName.equals("")) {
            fullName = fullName + "  " + lastName;
        }

        return fullName;
    }

    public ContactStruct() {
        super(MessageTypes.CONTACT);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ImageStruct getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ImageStruct profileImage) {
        this.profileImage = profileImage;
    }
}
