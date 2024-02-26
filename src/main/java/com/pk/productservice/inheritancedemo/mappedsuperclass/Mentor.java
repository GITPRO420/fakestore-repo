package com.pk.productservice.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "ms_Mentor")
public class Mentor extends User {

	@Id
	private Long mentorId;
	private double averageRating;
	private String email;

}
