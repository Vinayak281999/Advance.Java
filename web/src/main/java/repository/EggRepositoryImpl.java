package repository;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.EggDTO;
@Repository
public class EggRepositoryImpl implements EggRepository {

	@Autowired
	public EntityManagerFactory entityManagerFactory;
	public EggRepositoryImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}
	@Override
	public boolean save(EggDTO dto) {
		System.out.println("Running save in Egg repo");
		return false;
	}

}
