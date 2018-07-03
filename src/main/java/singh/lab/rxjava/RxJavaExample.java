package singh.lab.rxjava;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;

public class RxJavaExample {
        public static void main(String[] args) {
        	
        	
	        List<String> list = Arrays.asList("Android", "Ubuntu", "Mac OS"); 
	        Observable<List<String>> listObservable = Observable.just(list);  
	        
	        listObservable.subscribe(new Observer<List<String>>() { 
	        	
	        public void onCompleted() {
            	
            	System.out.println("on complted called");
            }

            
            public void onError(Throwable e) {
            	
            	System.out.println("onError called");
            }

          
            public void onNext(List<String> list) {
                                System.out.println(list);
            }
        });
	        
	        
	        

                
                
                
                
        }
}