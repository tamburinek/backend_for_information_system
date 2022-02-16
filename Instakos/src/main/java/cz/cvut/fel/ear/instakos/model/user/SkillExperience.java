package cz.cvut.fel.ear.instakos.model.user;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import javax.persistence.*;


@Entity
public class SkillExperience extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private String description;

    @Basic(optional = false)
    @Column(nullable = false)
    private String language;

    @Basic(optional = false)
    @Column(nullable = false)
    private int yearsOfExperience;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Language: " + language + " years of experience: " + yearsOfExperience + " short description" + description;
    }
}
