package singh.lab.java8.stream.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Transaction implements Comparable<Transaction> {

	private int transactionId;
	private Seller seller;
	private Double amount;
	
	
	
	public Transaction(int transactionId, Seller seller, Double amount) {
		super();
		this.transactionId = transactionId;
		this.seller = seller;
		this.amount = amount;
	}
	
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", seller=" + seller + ", amount=" + amount + "]";
	}

	public static <T> Predicate<T> distinctById(Function<? super T, ?> keyExtractor) {
	    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	
	@Override
	public int compareTo(Transaction o) {
		
		if (this.getTransactionId() == o.getTransactionId())
			return 0;
		else if (this.getTransactionId() > o.getTransactionId())
			return 1;

		else
			return -1;
	}
	
	
/*	t.getSeller().getAddr().getState().equals("NY"))
.mapToInt(t -> t.getAmount())*/
}
