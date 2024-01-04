package com.joboffer.Company;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String address;
    private String email;
    private String phoneNumber;
    @Column(columnDefinition = "oid")
    private byte[] image;
}
