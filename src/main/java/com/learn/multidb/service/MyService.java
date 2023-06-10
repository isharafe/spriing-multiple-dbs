package com.learn.multidb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.multidb.model.MyModel;
import com.learn.multidb.repository.MyModelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyService {

	private final MyModelRepository repo;

	@Transactional(readOnly = false)
	public MyModel save(MyModel obj) {
		return repo.save(obj);
	}

	@Transactional(readOnly = true)
	public MyModel read(Long id) {
		return repo.findById(id).orElse(null);
	}

}
