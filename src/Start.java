import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Start {
	
	static List<String>lines = new ArrayList<String>();
	
	
	public static void readIn(){
		

		String incoming     = "src/robin/round.csv";
		String line         = "";
		BufferedReader read = null;
		
		
		
		try{
			
			read = new BufferedReader(new FileReader(incoming));
			
					while((line = read.readLine()) != null){
						
							lines.add(line);
						
					}
			
			
			
			
		}catch(FileNotFoundException e){
			
				e.printStackTrace();
			
		}catch(IOException e){
			
				e.printStackTrace();
		}
		
		
		
		
		
	}
		
		
		
	
	
	
	public static void main(String[] args){
		
		
		readIn();
	}
		

}
