package com.mastertheboss.jpa;
import java.util.Iterator;
import java.util.List;
import javax.naming.LimitExceededException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.mastertheboss.domain.AvgLcmInput;
import com.mastertheboss.domain.AvgLcmResult;
import com.mastertheboss.domain.LcmCalculator;
import com.mastertheboss.domain.exception.NegativeNoException;

public class ResultInsertion {
	static AvgLcmInput avgLcmInput;
	static AvgLcmResult avgLcmResult = new AvgLcmResult();
	static LcmCalculator lcmCalculator = new LcmCalculator();

	public static void main(String[] args) throws LimitExceededException,
			NegativeNoException {
		EntityManager em = getTransaction();
		List<AvgLcmInput> unprocessedInputs = selectUnprocessedInputs(em);

		calculateResult(unprocessedInputs);
		updateStatus(unprocessedInputs, em);
		System.out.println("Results are inserted and Status is updated");
	}

	private static EntityManager getTransaction() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		return em;
	}

	private static void calculateResult(
			java.util.List<AvgLcmInput> unprocessedInputs)
			throws LimitExceededException, NegativeNoException {
        
		int resultId = 1;
		for (Iterator<AvgLcmInput> iterator = unprocessedInputs.iterator(); iterator
				.hasNext();) {
			EntityManager em = getTransaction();
			AvgLcmInput avgLcmInput = (AvgLcmInput) iterator.next();
           
			avgLcmResult.setResultId(resultId);
			avgLcmResult.setResult(lcmCalculator.calculateAverage(avgLcmInput
					.getNumber()));
			avgLcmResult.setAvgLcmInput(avgLcmInput);
			em.persist(avgLcmResult);
			em.flush();
			em.getTransaction().commit();
			resultId++;
		}
	}

	private static void updateStatus(List<AvgLcmInput> unprocessedInputs,
			EntityManager em) {
		for (Iterator<AvgLcmInput> iterator = unprocessedInputs.iterator(); iterator
				.hasNext();) {
			AvgLcmInput avgLcmInput = (AvgLcmInput) iterator.next();
			avgLcmInput.setStatus("Processed");
			em.persist(avgLcmInput);
		}
		em.flush();
		em.getTransaction().commit();
	}

	private static java.util.List<AvgLcmInput> selectUnprocessedInputs(
			EntityManager em) {
		@SuppressWarnings("unchecked")
		TypedQuery<AvgLcmInput> query = (TypedQuery<AvgLcmInput>) em
				.createQuery("SELECT avgLcmInput FROM AvgLcmInput avgLcmInput WHERE avgLcmInput.status IS NULL");
		return query.getResultList();
	}
  
	
  
}



