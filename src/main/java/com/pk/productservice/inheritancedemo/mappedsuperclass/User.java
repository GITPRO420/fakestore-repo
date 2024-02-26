package com.pk.productservice.inheritancedemo.mappedsuperclass;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class User {
	
	private String name;
	private String email;
	
}
