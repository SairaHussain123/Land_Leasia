package com.candella.service;

import java.util.List;

import com.candella.entity.Lessor;

public interface LessorService {

	public void addLessor(Lessor lessor);
	public void updateLessor(String l_id,String column_name);
	
	public List<Lessor> viewAllLessor();
public Lessor getLessor(String lessor_id);

}
