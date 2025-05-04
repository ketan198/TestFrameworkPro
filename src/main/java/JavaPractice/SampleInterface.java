/**
 * 
 */
package JavaPractice;


public interface SampleInterface {

	
	void method1();
	

	default void defmethod() {
		System.out.println("inside default method in 1st interface ");
		
	}
	
	static void statmethod() {
		
		System.out.println("Inside Static methods ");
	}
	
	
	
	
	
}
