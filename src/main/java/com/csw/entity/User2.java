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
public class User2 implements Serializable {
	private String username;
	private String password;
	private String truename;
	private String sex;

}
