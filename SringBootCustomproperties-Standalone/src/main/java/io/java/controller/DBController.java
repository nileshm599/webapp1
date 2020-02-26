package io.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.java.entity.StudentEntity;
import io.java.student.repository.StudentRepo;

@Component("dbController")
public class DBController {

	@Autowired(required = true)
	private StudentRepo studentrepo;

	public void getData() {

		List<StudentEntity> stdentt = new ArrayList<StudentEntity>();

		stdentt = studentrepo.findAll();
		System.out.println("-----------------------------------------------------");
		System.out.println(stdentt);
	}// getData

}// dbcontroller
