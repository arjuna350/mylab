package singh.lab.oneMethod.magic;

import java.util.function.Consumer;

public class ConsumerTest {
	
	 static void display(int value) {

	        switch (value) {
	        case 1:
	            System.out.println("There is 1 value");
	            return;
	        default:
	            System.out.println("There are " + Integer.toString(value)
	                    + " values");
	            return;
	        }
	    }
	 
	 
	 public void processValue(String str)
	 {
		 String newStr= "new "+str;
		 System.out.println(newStr);
	 }
	 
	 
	public static void main(String[] args) {
		  // This consumer calls a void method with the value.
        Consumer<Integer> consumer = x -> display(x - 1);

        // Use the consumer with three numbers.
        consumer.accept(1);
        consumer.accept(2);
        consumer.accept(3);
        
        
        ConsumerTest t = new ConsumerTest();
        
        Consumer<String> consumer2 = x -> t.processValue(x);
        consumer2.accept("hello");
        
	}

}
