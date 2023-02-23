package com.xworkz.valentine.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ValentineDTO {
	
	@Size(min = 3, max = 20, message = "Name can not be less than 3 and more than 20")
	private String name;
	@Size(min = 3, max = 20, message = "Name can not be less than 3 and more than 20")
	private String valentineName;
	@NotBlank(message = "Place can not be blank")
	private String place;
	@NotBlank(message = "Gift can not be blank")
	private String gift;
}
