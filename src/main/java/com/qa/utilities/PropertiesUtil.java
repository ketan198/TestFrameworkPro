	
package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.qa.Exceptions.PropertyFileUsageException;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigPropertiesEnums;

/**
 * @author Ketan Tiwari
 *
 */

// Since this is utility class hence ,  have restricted the unnecessary creation of objects for this class by declaring the custructo
//as private , hance made it as final as well so that no other class can inherit its properties.
public final class PropertiesUtil {

	private PropertiesUtil() {

	}
	public static  Properties PROP = new Properties();


	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfile());
			PROP.load(fis);



		} catch (IOException e) {

//		 throw new InvalidpathforPropertyfile(
//				 "path for property file is invalid");  cannot be used in static 
			e.printStackTrace();
			System.exit(0);
			
		 
		} 

	}

	public static String getPropertyValue(ConfigPropertiesEnums key) {

		if(PROP.getProperty(key.toString().toLowerCase())== null) {
			throw new PropertyFileUsageException("The " + key + " specified here is null please check.");
		}
		if(Objects.isNull(key)) {
		
			throw new PropertyFileUsageException("There is no property key defined in the COnfigPropertiesEnums");
		}
		return PROP.getProperty(key.toString().toLowerCase());

	}

}
