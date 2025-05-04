/**
 * 
 */
package JavaPractice;

/**
 * @author tiwar
 *
 */
public class MainClass extends AbstractParentClass implements SampleInterface , Sampleinterface2{

	@Override
	public void method1() {
		System.out.println("Inside interface");
		
	}
	@Override
	public void abstractmethod() {
		System.out.println("implementation of abstarct method ");
		
	}
	
	
	
	@Override
	public void defmethod() {
		
		
		Sampleinterface2.super.defmethod();
	}



	static AbstractParentClass abs ;
	
	public static void main(String[] args) {
		
		
		Sampleinterface2 sp = new MainClass();
		sp.method1();
		sp.defmethod();
		SampleInterface.statmethod();
	
		
		
	

	}

	

	

	
}
