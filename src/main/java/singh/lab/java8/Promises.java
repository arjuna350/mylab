package singh.lab.java8;

import java.util.concurrent.CompletableFuture;

public class Promises {
	
    private static class PageMetrics {
        Integer visits;
        Long avgMsOnPage;


        @Override
        public String toString() {
            return String.format("{ avgMsOnPage=%d, visits=%d }", avgMsOnPage, visits);
        }
    }

    
    
    private static class Summary {
        PageMetrics pageMetrics;

        long accountId;
        String description;
    }

    
    

    public static void main(String[] args) throws Exception {
        CompletableFuture<Summary> summaryPromise = CompletableFuture.supplyAsync(() -> {
            System.out.println("Creating summary object"+Thread.currentThread().getName());
            return new Summary();
        }).thenCompose((Summary summaryInstance) -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Populating summary object"+Thread.currentThread().getName());
            summaryInstance.accountId = 1l;
            summaryInstance.description = "PageMetrics Summary";

            // Arbitrary rest to demonstrate promise's behavior
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //
            }

            return summaryInstance;
        })).thenCompose((Summary summaryInstance) -> CompletableFuture.supplyAsync(() -> {
        	System.out.println("Populating PageMetrics object"+Thread.currentThread().getName());
        	PageMetrics pageMetrics = new PageMetrics();
            pageMetrics.visits = 4128;
            pageMetrics.avgMsOnPage = 4000L;
            summaryInstance.pageMetrics = pageMetrics;
            return summaryInstance;
        }));

        Summary summary = summaryPromise.get();
        System.out.println("Done!");
        System.out.println(summary.pageMetrics);
    }
}