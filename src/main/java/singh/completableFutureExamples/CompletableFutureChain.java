/**
 * 
 */
package singh.completableFutureExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;



/**
 * @author shaising
 *
 */
public class CompletableFutureChain {

	DqExecutor executor = new DqExecutor();
	DqResultMonitor monitor = new DqResultMonitor();
	DqResultUploder uploder = new DqResultUploder();
	
	ExecutorService baseExecutor = Executors.newFixedThreadPool(5);
	ExecutorService monitorExecutor = Executors.newFixedThreadPool(3);
	
	Function<String, String> executorFunction = profileId->executor.executeDq(profileId);
	Function<String, String> monitorFunction =  profileId->monitor.resultMonitor(profileId);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompletableFutureChain example = new  CompletableFutureChain();
		List<Job> jobs = new ArrayList<Job>();
		
		jobs.add(new Job("1"));
		jobs.add(new Job("2"));
		jobs.add(new Job("3"));
		jobs.add(new Job("4"));
		jobs.add(new Job("5"));
		
		System.out.println("Execution Started"+System.currentTimeMillis());

		for(Job job: jobs)
		{
			example.dqCheck(job);
		}
		
	
	}
	
	
	public void dqCheck(Job job)
	{

		CompletableFuture<Void> future = CompletableFuture
										.supplyAsync(()->job.getprofileId(),baseExecutor)
										.thenApplyAsync(executorFunction, baseExecutor)
										.thenApplyAsync(monitorFunction, monitorExecutor)
										.thenAcceptAsync(profileId->uploder.resultUploder(profileId), baseExecutor);
			
	}

}
