package singh.lab.concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChainingTest {

	 public static void main(String[] args) {
		 
		 CompletableFuture<String> future = CompletableFuture.completedFuture("foo");
		 
		 future = future.thenApplyAsync(str -> {
			 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     System.out.println("Stage 1: " + str);
		     return "bar";
		 });
		 
		 
		 
		 future.thenApplyAsync(str->{
			 System.out.println("stage2"+str);
			 try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 return str+"char";});
		 
		 future.exceptionally(ex -> "Error: " + ex.getMessage());
		 
		 future = future.thenApplyAsync(str -> {
		     System.out.println("Stage 3: " + str);
		     try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    return str+"har";
		 });
		 
		 
		 
		 
		 
	 }
}
