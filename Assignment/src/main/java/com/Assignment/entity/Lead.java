package com.Assignment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "leads")
public class Lead {
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leadId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$")
    private String middleName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String mobileNumber;

    @NotBlank
    @Pattern(regexp = "^(Male|Female|Others)$")
    private String gender;

    @NotNull
    @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @NotBlank
    @Email
    private String email;
}

