package ntu.poly.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {
	
	@Id
	@Column(length = 30)
	private int productId;
	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 10, nullable = false)
	private int quantity;
	@Column(length = 10, nullable = false)
	private double unitPrice;
}
