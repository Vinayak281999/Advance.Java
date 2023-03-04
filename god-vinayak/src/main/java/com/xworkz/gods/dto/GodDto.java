package com.xworkz.gods.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class GodDto {
  
	private int id;
   @NotNull
   @Size(min=3,max=20,message="greater than 3")
	private String name;
   @NotNull(message = "Vehicle should not null")
	private String vehicle;
   @NotNull(message = "Country should not null")
	private String counties;
   @NotBlank(message = "religion should not null")
	private String religion;
}

