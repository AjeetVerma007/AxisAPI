package com.lichfl.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "user_details_api")
@Component
public class CustomUserDetails {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	Long userId;
	
	@Column(name = "user_name")
	private String userName;
	
	private String password;
	
	@Column(name="module_name")
	private String moduleName;
	
	private  String status;
	
	@Column(name = "created_date")
    @CreationTimestamp
	private LocalDateTime createdDate;

}
