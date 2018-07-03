package singh.lab.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import singh.lab.java8.stream.beans.Address;
import singh.lab.java8.stream.beans.Seller;
import singh.lab.java8.stream.beans.Transaction;

public class StreamExample1 {

public static String[] getPath(String absolutePath) {
	if(absolutePath==null || !absolutePath.contains("/") )
	{
		return new String[0];
	}
		String[] list = absolutePath.split("/");

		List<String> pathList = Arrays.asList(list).stream().filter(string ->  (!"".equals(string) && string!=null))
				.collect(Collectors.toList());

		String[] pathArray = pathList.toArray(new String[pathList.size()]);

		return pathArray;

	}

	public static void main(String[] args) {
		
		System.out.println("/root/a/b".startsWith("/root"));
		System.out.println("/root/a/b".startsWith("/root/a/b"));
		System.out.println("/root/a/b".startsWith("/root/c/b"));
		
		System.out.println(StreamExample1.getPath("abcdf").length);
		System.out.println(StreamExample1.getPath(null).length);
		System.out.println(StreamExample1.getPath("").length);
		System.out.println(StreamExample1.getPath("/").length);
		

		Transaction t1= new Transaction(100,new Seller(001, new Address("NY","NY")),10d);
		Transaction t2= new Transaction(101,new Seller(001, new Address("NJ","NJ")),10d);
		Transaction t3= new Transaction(102,new Seller(001, new Address("NY","NY")),100d);
		Transaction t4= new Transaction(103,new Seller(001, new Address("DC","DC")),10d);
		Transaction t5= new Transaction(104,new Seller(001, new Address("NY","NY")),150d);
		Transaction t6= new Transaction(104,new Seller(001, new Address("NY","NY")),250d);
		
		
		Transaction transactions[] = {t1,t2,t3,t4,t5,t6};
		List<Transaction> transactionList=Arrays.asList(transactions);
		
		//1.Java 8 new ForeachLoop
		/*
		transactionList.forEach(new Consumer<Transaction>(){

			@Override
			public void accept(Transaction t) {
				System.out.println(t.toString());
				
			}
			
		});*/
		
		
		
		
		//2. Java stream 
		/*double nyTransactionSum= Arrays.stream(transactions)
				.filter(t->t.getSeller().getAddress().getState().equals("NY")).mapToDouble(t->t.getAmount()).sum();
		
		System.out.println("Transacrtion sum of NY state:"+nyTransactionSum);
		
		
		//3. java 8 new for each with stream
		
		Arrays.stream(transactions).forEach(System.out::println);*/
		
		//4.Transaction amount greater than 50 , 
		
		//transactionList.stream().filter(txn->txn.getAmount()>50d).distinct().forEach(System.out::println);
		
		transactionList.stream().filter(txn->txn.getAmount()>50d).filter(Transaction.distinctById(p -> p.getTransactionId())).forEach(System.out::println);
	}

}
