package practice;

import edu.duke.FileResource;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import edu.duke.*;

class CalculatePerimeter {
	

	public static void main(String[] args) throws IOException  {
		
		File f = new File("C:\\Users\\User\\Desktop");
		
		String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\Desktop\\in.txt"))); 
		
		boolean res = Files.isWritable(Paths.get("C:\\\\Users\\\\User\\\\Desktop\\\\out.txt"));
		
		//BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		
		//System.out.println(f.getName());
		
		//writer.write(content);
		//writer.close();
		
		String s = "abcdefg";
		String st = s.substring(3);
		System.out.println(st);
		
	}

}