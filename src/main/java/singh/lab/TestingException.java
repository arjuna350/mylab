package singh.lab;

public class TestingException {

	public static int f1()
	{
		try{
			int i=80;
			throw new Exception();
			//return 10;
		}
		catch(Exception e)
		{
			throw new Exception();
			//return 20;
			
		}
		finally
		{
			return 30;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(TestingException.f1());

	}

}
