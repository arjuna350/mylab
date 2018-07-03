package singh.lab.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureCallback {
	
	static ExecutorService executor = Executors.newFixedThreadPool(10);
	
	
        public static void main(String[] args) {
                long started = System.currentTimeMillis();

                
                
                CompletableFuture<String>  data = createCompletableFuture()
                            .thenApplyAsync((Integer count) -> {
                            	System.out.println("thenApplyAsync:"+Thread.currentThread().getName());
                                int transformedValue = count * 10;
                                return transformedValue;
                            },executor).thenApply(transformed -> "Finally creates a string: " + transformed);

                        try {
                            System.out.println(data.get());
                        } catch (InterruptedException | ExecutionException e) {

                        }
        }

        public static CompletableFuture<Integer> createCompletableFuture() {
                CompletableFuture<Integer>  result = CompletableFuture.supplyAsync(() -> {
                try {
                    // simulate long running task
                	System.out.println("createCompletableFuture:"+Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) { }
                return 20;
            },executor);
                return result;
        }

}