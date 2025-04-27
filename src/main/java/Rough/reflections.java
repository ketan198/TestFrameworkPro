/**
 * 
 */
package Rough;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author tiwar
 *
 */

class  asas{
	public void some() {
		System.out.println("asdada");
	}
}
public class reflections {
	
	
	private static final String s = "what is this" ; 
	
	public static String somemethod() {
		return "BCD";
		
		
	}

	
	public static void reflect(Method m ) {
		
		System.out.println("method name " + m.getName());
		System.out.println("method class " + m.getDeclaringClass());
		
	}
	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		
		Method m = reflections.class.getMethod("somemethod");
		reflect(m);
		
		String name_of_class = m.getDeclaringClass().toGenericString();
		
		Field b = reflections.class.getDeclaredField(s);
		
		b.setAccessible(true);
		
	
		
		
		
		Object a = m.getDeclaringClass().getDeclaredConstructor().newInstance();
		
		String p = (String) m.invoke(a);
		
		System.out.println(p);
		System.out.println(name_of_class);
		
		
		
		
		
		

	}
	
	
	
	

}
