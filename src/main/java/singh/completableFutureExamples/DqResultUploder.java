package singh.completableFutureExamples;

public class DqResultUploder {

	
	public String resultUploder(String profileId)
	{
		
		System.out.println(Thread.currentThread().getName()+"Profile result uploaded  for "+profileId);
		System.out.println("Execution completed"+System.currentTimeMillis());
		return profileId;
		
	}
	
}
