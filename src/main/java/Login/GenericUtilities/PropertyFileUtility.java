package Login.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String getPropertyFileValue(String valueKey) throws IOException {
		FileInputStream file= new FileInputStream(IConstantutility.propertyFilePath);
		Properties pro= new Properties();
		pro.load(file);
		return pro.getProperty(valueKey);
	}	
	
	
}
