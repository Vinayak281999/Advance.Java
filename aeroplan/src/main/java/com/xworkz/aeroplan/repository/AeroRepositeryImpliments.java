package com.xworkz.aeroplan.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.aeroplan.entity.AeroEntity;
@Repository
public class AeroRepositeryImpliments implements AeroRepositery {

	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	
	@Override
	public boolean save(AeroEntity aentity) {
		EntityManager em=this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.persist(aentity);
		transaction.commit();
		em.close();
		return false;
	}
	@Override
	public AeroEntity findByid(int id) {
		System.out.println("find by id in repo");
		EntityManager em=this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		AeroEntity fromDb = em.find(AeroEntity.class,id);
		em.close();
		return fromDb;
		
	}

}
