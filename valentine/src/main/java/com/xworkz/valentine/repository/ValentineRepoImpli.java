package com.xworkz.valentine.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.valentine.entity.ValentineEntity;

@Repository
public class ValentineRepoImpli implements ValentineRepository {
	@Autowired
	private EntityManagerFactory entityMangaerFactory;

	public ValentineRepoImpli() {
		System.out.println("running valentine repo ");
	}

	@Override
	public boolean save(ValentineEntity valentineEntity) {
		System.out.println("running save in repository");
		EntityManager em = this.entityMangaerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(valentineEntity);
		et.commit();
		em.close();
		return true;

	}

}
