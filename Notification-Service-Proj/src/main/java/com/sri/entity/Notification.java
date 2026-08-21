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
@Table(name="Notification_DB")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notification {

	@Id
	@SequenceGenerator(name="gen4",sequenceName = "s4",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen4",strategy=GenerationType.AUTO)
	private Integer notificationId;
	@Nonnull
	private Integer paymentId;
	@Nonnull
	private String notificationType;
	@Nonnull
	private String message;
	@Nonnull
	private String notificationStatus;
}
