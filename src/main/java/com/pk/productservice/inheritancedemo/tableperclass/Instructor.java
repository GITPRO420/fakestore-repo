package com.pk.productservice.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="tpc_Instructor")
@EqualsAndHashCode(callSuper=false)
public class Instructor extends User {
	
	
	private String favouriteStudent;
}
