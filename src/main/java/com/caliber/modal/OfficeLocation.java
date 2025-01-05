package com.caliber.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OFFICE_LOCATION")
@Getter
@Setter
//@NoArgsConstructor
public class OfficeLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "OFFICE_ID",  nullable = false, unique = true, length = 50)
    private String officeId;

    @Column(name = "ADDRESS", nullable = false, length = 255)
    private String location;

    @Column(name = "city", nullable = false, length = 100)
    private String city;
    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "zipcode", length = 20, nullable = false)
    private String zipcode;

    @Column(name = "mobile", length = 20, nullable = false)
    private String mobile;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    public OfficeLocation() {
    }

    public OfficeLocation(String officeId, String location, String city, String state, String country, String zipcode, String mobile, String email) {
        this.officeId = officeId;
        this.location = location;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.mobile = mobile;
        this.email = email;
    }
}
