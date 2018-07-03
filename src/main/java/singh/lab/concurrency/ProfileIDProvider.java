package singh.lab.concurrency;

import java.util.function.Supplier;

public class ProfileIDProvider {

	private String profileId;
	
	
	
	
	//@Override
	public String get() {

		System.out.println("Profile submitted for execution::::::::");
		return "first";
	}




	public ProfileIDProvider(String profileId) {
		super();
		this.profileId = profileId;
	}
}