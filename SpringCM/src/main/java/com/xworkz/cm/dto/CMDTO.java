package com.xworkz.cm.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString

public class CMDTO {

	@NotBlank(message = "cm name can not be null or blank")
	@Size(min=3,max=20,message="cm name should be more than 3 and less than 20")
private String name;	
	@NotBlank(message = "party can not be null or blank")
private String party;
	@NotBlank(message = "state can not be null or blank")
private String state;
	@NotBlank(message = "tenure can not be null or blank")
	@Size(min=3,max=20,message="tenure should be more than 3 and less than 20")
private int tenure;	
	@NotBlank(message = "portFoliocan not be null or blank")
private String portFolio;	
}
