package singh.lab.java8.stream.beans;

public class Seller {
	
	private int id;
	private Address address;
	
	
	public Seller(int id, Address address) {
		super();
		this.id = id;
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Seller [id=" + id + ", address=" + address + "]";
	}
	

}
