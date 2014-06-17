package com.mastertheboss.jpa;
import javax.persistence.*;
import com.mastertheboss.domain.AvgLcmInput;

public class DataInsertion {

	public static void main(String[] args) {
		EntityManager em = getTransaction();
		try {
			insertData(args,em);
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.getTransaction().commit();
		System.out.println("Data is inserted "); 
   }

	public static void insertData(String[] args, EntityManager em) {
		int Id = 1;
		for (String value : args)
		{
			AvgLcmInput avgLcmInput = new AvgLcmInput();
			avgLcmInput.setNumber(Integer.valueOf(value));
			avgLcmInput.setStatus(null);
			avgLcmInput.setInputId(Id);
             
			Id++;
			em.persist(avgLcmInput );
			
	    }
    }
	
	private static EntityManager getTransaction() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		return em;
	}

	
   
}









