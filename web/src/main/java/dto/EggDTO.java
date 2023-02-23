package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "egg")

public class EggDTO {

	@Column(name = "id")
	@Id
	private Integer id;
	@Column(name = "e_hotelName")
	private String hotelName;
	@Column(name = "e_dishName")
	private String dishName;
	@Column(name = "e_type")
	private String type;
	@Column(name =  "e_price")
	private Double price;
	@Column(name =  "e_quantity")
	private Integer quantity;
	@Column(name = "e_takeAway")
	private Boolean takeAway;
	
	public void EggDTO() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

}