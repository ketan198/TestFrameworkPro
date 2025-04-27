package Rough;

public class EnumsDEMOCLASS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Severity.CRITICAL);
		
		
		if(Severity.valueOf("CRITICAL") == Severity.CRITICAL) {
			
			System.out.println("True");
			
		}
		
		
		

	}

}
