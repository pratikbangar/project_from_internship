import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import javax.naming.LimitExceededException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.mastertheboss.domain.AvgLcmInput;
import com.mastertheboss.domain.AvgLcmResult;
import com.mastertheboss.domain.LcmCalculator;
import com.mastertheboss.domain.exception.NegativeNoException;


public class ResultInsertionTest {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("persistenceUnit");
	EntityManager em = factory.createEntityManager();
//	em.getTransaction().begin();

	@Test
	public void testcalculateResult() throws LimitExceededException, NegativeNoException
	{
		AvgLcmResult avgLcmResult = new AvgLcmResult();
		LcmCalculator lcmCalculator = new LcmCalculator();
		avgLcmResult.setResult(lcmCalculator.calculateAverage(5));
		assertEquals(avgLcmResult.getResult(), 11);
	}
   
//	@Test
   public void selectUnprocessedInputs()
   {
	 
	   @SuppressWarnings("unchecked")
		TypedQuery<AvgLcmInput> query = (TypedQuery<AvgLcmInput>) em
				.createQuery("SELECT avgLcmInput FROM AvgLcmInput avgLcmInput WHERE avgLcmInput.status IS NULL");
		
		List<AvgLcmInput> unprocessedInputs =  query.getResultList();
		for (Iterator<AvgLcmInput> iterator = unprocessedInputs.iterator(); iterator
				.hasNext();)
		{
			AvgLcmInput avgLcmInput = (AvgLcmInput) iterator.next();
			assertEquals(avgLcmInput.getStatus(), null);
		} 
   }
}
