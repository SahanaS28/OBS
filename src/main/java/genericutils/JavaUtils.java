package genericutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class JavaUtils
{
	/**
	 * this method is used to append random number
	 * @author Dell
	 * @return
	 */
	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
		
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt=new Date();
		String date=dt.toString();
		return date;
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt=new Date();
		String date = dateformat.format(dt);
		return date;
	}

}
