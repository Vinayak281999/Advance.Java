package com.xworkz.aeroplan.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AeroplanDto {
      @Id
      private int id;
	@NotNull
	@Size(min=3,max=20,message="greater than 3")
	private String company;
	@NotNull
	@Size(min=3,max=20,message="greater than 3")
	private String name;
	@NotNull
	
	private Double cost;
	@NotNull
	@Size(min=3,max=20,message="greater than 3")
	private String type;
	@NotNull
	@Size(min=3,max=20,message="greater than 3")
	private String country;
}
