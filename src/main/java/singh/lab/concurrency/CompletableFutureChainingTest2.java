package singh.lab.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureChainingTest2 {
	
	  private void test() throws ExecutionException, InterruptedException {

	        ExecutorService executor = Executors.newFixedThreadPool(3);

	        CompletableFuture<ProfileIDProvider> f = CompletableFuture.supplyAsync(() -> executeTask("T1"), executor);

	       // System.out.println("Is task completed 1 [" + f.isDone() + "]");

	        f.thenApplyAsync(t -> {
	        	System.out.println(t.get());
	            System.out.println("Inside then apply async [" + Thread.currentThread().getName() + "]");
	            return t.get()+"Second";
	        }, executor).thenApply(t -> {
	        	System.out.println(t);
	            System.out.println("Inside then apply [" + Thread.currentThread().getName() + "]");
	            return t+"Third";
	        }).whenComplete((t, e) -> {
	        	System.out.println(t);
	            System.out.println("Inside when complete [" + Thread.currentThread().getName() + "]");
	        });

	      //  System.out.println("Is task completed 3 [" + f.isDone() + "]");

	       
	   

	      //  System.out.println("Main thread completed");
	    }

	    private ProfileIDProvider executeTask(String name) {
	        System.out.println("Inside task [" + name + "] thead[" + Thread.currentThread().getName() + "]");
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Task execution complete");
	        return new ProfileIDProvider(name);
	    }

	
	 public static void main(String[] args) throws ExecutionException, InterruptedException {
	 
		 new CompletableFutureChainingTest2().test();
	 
	 }
	 
	 
	 
}
