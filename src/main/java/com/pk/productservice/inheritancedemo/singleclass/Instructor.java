package com.pk.productservice.inheritancedemo.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue(value = "1")
public class Instructor extends User {

	private String favouriteStudent;
}
