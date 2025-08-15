package model;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class CustomerInfo {

    private String custID;
    private String title;
    private String name;
    private Date dob;
    private double salary;
    private String address;
    private String city;
    private String province;
    private String postalcode;

}

