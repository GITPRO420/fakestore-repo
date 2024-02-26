package com.pk.productservice.models;

import java.time.Instant;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Instant createdAt;
	private Instant lastUpdatedAt;
	private boolean isDeleted;
}
