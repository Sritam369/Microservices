package com.sri.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Orders_DB")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {

	@Id
	@SequenceGenerator(name="gen2",sequenceName = "s2",allocationSize = 1,initialValue = 100)
	@GeneratedValue(generator="gen2",strategy=GenerationType.AUTO)
	private Integer orderId;
	@Nonnull
	private Integer productId;
	@Nonnull
	private Integer orderQuantity;
	@Nonnull
	private Double orderPrice;
	@Nonnull
	private String orderStatus;
}
