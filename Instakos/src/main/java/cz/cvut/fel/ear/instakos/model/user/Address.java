package cz.cvut.fel.ear.instakos.model.user;

import cz.cvut.fel.ear.instakos.model.AbstractEntity;
import javax.persistence.*;


@Entity
@Table(name = "INSTAKOS_ADRESS")
public class Address extends AbstractEntity {

    @Basic(optional = false)
    @Column(nullable = false)
    private String street;

    @Basic(optional = false)
    @Column(nullable = false)
    private String city;

    @Basic(optional = false)
    @Column(nullable = false)
    private String state;

    @Basic(optional = false)
    @Column(nullable = false)
    private int zipcode;

    @Basic(optional = false)
    @Column(nullable = false)
    private int houseNumber;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address: " + state + " ," + zipcode + " ," + city + " ," + street + " ," + houseNumber;
    }
}
