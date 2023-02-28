package com.xworkz.gods.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.xworkz.gods.entity.GodEntity;



@Repository
public class GodRepositeryImpliments implements GodRepositery {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean save(GodEntity gentity) {
		EntityManager em=this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.persist(gentity);
		transaction.commit();
		em.close();
		return true;
	}
	@Override
	public GodEntity findByid(int id) {
		System.out.println("find by id in repo");
		EntityManager em=this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		GodEntity fromDb = em.find(GodEntity.class,id);
		em.close();
		return fromDb;
		
	}
}
