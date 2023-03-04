package com.xworkz.gods.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.gods.entity.GodEntity;

@Repository
public class GodRepositeryImpliments implements GodRepositery {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean save(GodEntity gentity) {//from service
		EntityManager em = this.entityManagerFactory.createEntityManager();
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
		EntityManager em = this.entityManagerFactory.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
		
		GodEntity ent = em.find(GodEntity.class, id);
		em.close();
		System.out.println("jjjjjjjjjjjjjj"+ent);
		return ent;

	}

	@Override
	public List<GodEntity> findByName(String name) {
		System.out.println("Inside searchByDepo method " + name);
		EntityManager manager = this.entityManagerFactory.createEntityManager();

		try {

			Query query = manager.createNamedQuery("findByName");
			query.setParameter("by", name);
			List<GodEntity> list = query.getResultList();
			System.out.println("Total list fount is " + list.size());
			return list;

		} finally {
			manager.close();
		}

	}
	@Override
	public boolean update(GodEntity entity) {
		EntityManager manager=this.entityManagerFactory.createEntityManager();
		//Dectde
		try {
			EntityTransaction transaction=manager.getTransaction();
			
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			
			return true;	
			
		} finally {
			manager.close();
		}
	}
	
	public boolean onDelete(int id) {
		EntityManager manager=this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		GodEntity entity=manager.find(GodEntity.class,id);
		if (entity!=null) {
			
			transaction.begin() ;
			manager.remove(entity);
			transaction.commit();
			manager.close();
			
		} else {
			System.out.println("Data is not deleted");

		}
		return true;
		
	}
}
