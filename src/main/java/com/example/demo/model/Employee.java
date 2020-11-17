package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue
	private Integer eid;
	private String ename;
	private Double esal;
	private String addr;
	private Double hra;
	private Double da;

}
