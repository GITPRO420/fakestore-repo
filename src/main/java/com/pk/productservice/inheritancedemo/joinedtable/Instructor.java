package com.pk.productservice.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "jt_Instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {

	private String favouriteStudent;
}
