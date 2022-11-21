package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Customer {
	@Id
	@Column
	private int id;
	@Column
	@NotNull
	@Size(max = 15, message = "Maximum length must be 15")
	private String customerName;
	@Column
	private String gender;
	@Column
	@JsonIgnore
	private String city;
}
