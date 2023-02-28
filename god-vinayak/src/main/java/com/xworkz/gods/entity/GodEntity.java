package com.xworkz.gods.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Data
@Table(name="god_table")
public class GodEntity {

	@Id
	@Column(name = "id")
	   private int id;
	   
	@Column(name = "name")
		private String name;
	@Column(name = "vehicle")
		private String vehicle;
	@Column(name = "country")
		private String country;
	@Column(name = "religion")
		private String religion;
}
