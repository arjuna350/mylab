package singh.lab;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	http://www.google.com
    		System.out.println("Hello world");
		
		
		
		System.out.printf("Done..."); 
		
		
        System.out.println( "Hello World!" );
        
        String path ="/x/y";
        String[] list = path.split("/");
        
         Arrays.asList(list).stream().forEach(a -> {
             System.out.println(a);});
         
             
         Stream.of( "a", "", "b", "", "c", "" ,null).filter(string -> (!"".equals(string) && string!=null)).forEach(a -> {
             System.out.println(a);});
         
         
         System.out.println(" check od string:"+"".equals(null));
      
}
}
