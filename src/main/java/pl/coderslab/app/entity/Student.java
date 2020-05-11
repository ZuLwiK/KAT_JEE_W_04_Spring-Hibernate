package pl.coderslab.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private boolean mailingList;
    private List<String> programmingSkills;
    private List<String> hobbies;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public List<String> getProgrammingSkills() {
        return programmingSkills;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }

    public void setProgrammingSkills(List<String> programmingSkills) {
        this.programmingSkills = programmingSkills;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
