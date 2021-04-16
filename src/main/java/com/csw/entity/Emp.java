package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain =true)
public class Emp implements Serializable {
	private Integer id;
	private String name;
	private Double salary;
	private Integer age;
	private Dept dept;
}
