/**
 * @author dhanya
 * Entity class for Employee table
 *
 */
package com.management.employee.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee_TBL")
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int employeeId;
   private String employeeName;
   
   @JsonFormat(pattern="yyyy-MM-dd")
   private Date dateOfBirth;
   
   private String panNumber;
   private String address;
   
   @OneToOne(targetEntity = Department.class,fetch = FetchType.LAZY)   
   @JsonBackReference
   //@JoinColumn(name="depid_fk",referencedColumnName = "departmentId")
   @JoinColumn(name = "departmentId", unique = false, nullable = false)
   private Department department;
}