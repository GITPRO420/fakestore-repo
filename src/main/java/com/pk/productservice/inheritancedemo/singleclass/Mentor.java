package com.pk.productservice.inheritancedemo.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue(value = "2")
public class Mentor extends User {

	private double averageRating;

}
