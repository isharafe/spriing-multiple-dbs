package com.learn.multidb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.multidb.model.MyModel;
import com.learn.multidb.service.MyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/my")
public class MyController {

	private final MyService myService;

	@PostMapping
	public MyModel save(@RequestBody MyModel model) {
		return myService.save(model);
	}

	@GetMapping("/{id}")
	public MyModel read(@PathVariable Long id) {
		return myService.read(id);
	}

}
