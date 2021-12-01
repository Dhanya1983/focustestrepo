package com.management.employee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Department_TBL")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentId", unique = true, nullable = false)
	private int departmentId;
	private String departmentName;
	private String departmentHead;
	
	@JsonManagedReference
	//@OneToOne(mappedBy = "department")
	@OneToOne(fetch = FetchType.LAZY, cascade =CascadeType.ALL,  orphanRemoval = true, mappedBy = "department")
	private Employee employee;
}
