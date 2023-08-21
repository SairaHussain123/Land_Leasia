package com.candella.dao;

import java.util.List;

import com.candella.entity.Lessor;

public interface LessorDao {
	public void addLessor(Lessor lessor);

	List<Lessor> viewAllLessor();



	Lessor getLessor(String lessor_id);

}
