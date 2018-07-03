package singh.lab.oneMethod.magic;

import java.util.function.Function;

public class FunctionTest {
	
	
	 public String processValue(String str)
	 {
		 String newStr= "new "+str;
		 //System.out.println(newStr);
		 return newStr;
	 }
	 

	public static void main(String[] args) {
		 // Create a Function from a lambda expression.
        // ... It returns the argument multiplied by two.
        Function<Integer, Integer> func = x -> x * 2;

        // Apply the function to an argument of 10.
        int result = func.apply(10);
        System.out.println(result);

        
        FunctionTest t = new FunctionTest();
        
        Function<String, String> func1 = x -> t.processValue(x);
        
        System.out.println(func1.apply("hello"));
        
        
	}

}
