package com.learn.multidb.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "my_model")
public class MyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;
	private String name;
	private Date bod;

}
