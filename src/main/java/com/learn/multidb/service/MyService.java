package com.learn.multidb.service;

import org.springframework.stereotype.Service;

import com.learn.multidb.model.MyModel;
import com.learn.multidb.repository.MyModelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyService {

	private final MyModelRepository repo;

	public MyModel save(MyModel obj) {
		return repo.save(obj);
	}

	public MyModel read(Long id) {
		return repo.findById(id).orElse(null);
	}

}
