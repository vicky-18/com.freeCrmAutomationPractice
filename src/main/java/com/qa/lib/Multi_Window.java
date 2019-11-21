package com.qa.lib;

import java.util.Iterator;
import java.util.Set;

import com.qa.base.Base;

public class Multi_Window extends Base
{
	
	public static void handleWindow()
	{
		String parent = driver.getWindowHandle();
		
		Set <String> windows = driver.getWindowHandles();
		
		Iterator<String> ita = windows.iterator();
		
		while(ita.hasNext())
		{
			String child_window = ita.next();
			
			if(!parent.equals(child_window))
			{
				System.out.println(driver.switchTo().window(child_window));
			}
		}
	}

}
