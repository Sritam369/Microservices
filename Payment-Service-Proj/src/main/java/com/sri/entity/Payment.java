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
@Data
@Table(name="Payment_DB")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@SequenceGenerator(name="gen3",sequenceName = "s3",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen3",strategy=GenerationType.AUTO)
	private Integer paymentId;
	@Nonnull
	private Integer orderId;
	@Nonnull
	private Double amount;
	@Nonnull
	private String paymentMode;
	@Nonnull
	private String paymentStatus;
}
