package genericutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils
{

	

	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropetyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
				
		
	}

	
	
}
