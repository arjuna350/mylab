package singh.completableFutureExamples;

import java.util.concurrent.locks.Lock;
import java.util.function.Function;

public class EnhancedDqResultMonitor implements Function<String, String>{

	private Object lock ;
	
	public EnhancedDqResultMonitor(Object lock)
	{
		this.lock=lock;
	}
	
	
	public String resultMonitor(String profileId) throws InterruptedException
	{
		int i=0;
		
		synchronized (lock)
		{
			
			while(i<5)
			{
				Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName()+"Waitig For profile Result of"+profileId);
				lock.notifyAll();
				lock.wait();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+"Profile result received for "+profileId);
				
		return profileId;
		
	}

	@Override
	public String apply(String profileId) {
		
		String result = null;
		try {
			result= this.resultMonitor(profileId);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
