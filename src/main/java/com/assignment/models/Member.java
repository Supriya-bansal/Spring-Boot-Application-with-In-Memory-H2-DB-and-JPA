package com.assignment.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Validated
public class Member implements Serializable {
 
	private static final long serialVersionUID = 6288697488339940555L;

	private @Id @GeneratedValue Long id;
    
    @NotBlank(message = "Please provide First name")
    private String firstName;
    
    @NotBlank(message = "Please provide Last name")
    private String lastName;
    
    @NotBlank(message = "Please provide Postal code")
    private String postalCode;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull(message = "Please provide Date of birth")
    private LocalDate dateOfBirth;
    
    public Member() {
	}


	public Member(String firstName, String lastName,String postalCode,LocalDate dateOfbirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfbirth;
    }

	
	public Long getId() {
		return id;
	}


	/*
	 * public void setId(Long id) { this.id = id; }
	 */


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


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
    
}
