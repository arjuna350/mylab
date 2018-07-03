package singh.completableFutureExamples;

import java.util.function.Function;

public class DqResultMonitor implements Function<String, String>{

	
	public String resultMonitor(String profileId)
	{
		for(int i=0; i<5; i++)
		{
			try {
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName()+"Waitig For profile Result of"+profileId);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(Thread.currentThread().getName()+"Profile result received for "+profileId);
				
		return profileId;
		
	}

	@Override
	public String apply(String profileId) {
		return this.resultMonitor(profileId);
	}
}
