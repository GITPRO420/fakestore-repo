package com.pk.productservice.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name="tpc_Mentor")
public class Mentor extends User{
	
	
	private double	averageRating;
	
	
}
