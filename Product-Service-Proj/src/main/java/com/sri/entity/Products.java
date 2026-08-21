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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Products_DB")
public class Products {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.AUTO)
	private Integer productId;
	@Nonnull
	private String productName;
	@Nonnull
	private String productDescription;
	@Nonnull
	private Double productPrice;
	@Nonnull
	private Integer productQuantity;
	@Nonnull
	private String productCategory;
}
