package com.service.eventLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class EventLoggerService 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String fileName = args[1];
                     
        try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = reader.readLine()) != null) {
				parse(line);
			}
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
        
    }

	private static Event parse(final String line) {		
		
		return null;
	}
}
