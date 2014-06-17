import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mastertheboss.domain.AvgLcmInput;


public class DataInsertionTest {

	 @Test
	   public void testinsertData()
	   {     String[] args = {"1", "2", "3", "4"};
	        
	         int i = 1;
			  for (String value : args)
		  {
			AvgLcmInput avgLcmInput = new AvgLcmInput();
			avgLcmInput.setNumber(Integer.valueOf(value));
			
		    
	        assertTrue((avgLcmInput.getNumber()==i));
			i++; 
			}
		   
	   }
}
