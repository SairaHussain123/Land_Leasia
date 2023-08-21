package com.candella.service;

import java.util.List;

import com.candella.dao.LessorDaoImpl;
import com.candella.entity.Lessor;

public class LessorServiceImpl implements LessorService {
	LessorDaoImpl lessorDaoImpl=new LessorDaoImpl();

	public void addLessor(Lessor lessor) {
		// TODO Auto-generated method stub
		lessorDaoImpl.addLessor(lessor);
		return;
	}

	public void updateLessor(String l_id, String column_name) {
		// TODO Auto-generated method stub
		lessorDaoImpl.updateLessor(l_id,column_name);
		return;
	}

	public List<Lessor> viewAllLessor() {
		// TODO Auto-generated method stub
		return lessorDaoImpl.viewAllLessor();
	}

	


	@Override
	public Lessor getLessor(String lessor_id) {
		// TODO Auto-generated method stub
		
		return lessorDaoImpl.getLessor(lessor_id);
	}}
