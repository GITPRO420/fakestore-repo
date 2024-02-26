package com.pk.productservice.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="ms_Instructor")
@EqualsAndHashCode(callSuper=false)
public class Instructor extends User {
	
	@Id 
	private Long instructorId;
	private String favouriteStudent;
}
