package singh.completableFutureExamples;

import java.util.function.Function;

public class DqExecutor   {

	
	public String executeDq(String profileId)
	{
		System.out.println(Thread.currentThread().getName()+"Profile submitted For Execution"+profileId);
				
		return profileId;
		
	}

	
}
