package robin;
import java.util.*;
import robin.Que;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class RoundStart {
	
	
	static List<String>lines        = new ArrayList<String>();
	static List<Que>process         = new LinkedList<Que>();
	static List<Que>sorted          = new LinkedList<Que>();
	static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	
	static String textArrive[];
	static int arrivalTime[]       = null;
	static int pID[]		           = null;
	static int burstTime[]	       = null;
	static int order[]			   = null;
	static int numbers[]           = null;

public static void printOut(){
	
	
	for(int i = 1; i <= lines.size() -1; i++){
		
			System.out.println(lines.get(i));
	}
	
	
	
}

public static void timeSet(){
	
	
	
}

public static void breakUp(List<String> list){
	
	String i  = null;
	String a  = null;
	String b  = null;
	
	int id;
	int arrival;
	int burst;
	 
	for(int k = 1; k <= list.size() -1; k++){
		
		textArrive = list.get(k).split(",");
		
		i = textArrive[0];
		a = textArrive[1];
		b = textArrive[2];
		
		id      = Integer.parseInt(i);
		arrival = Integer.parseInt(a);
		burst   = Integer.parseInt(b);
		
		arrivalTime = new int[list.size()];
		burstTime   = new int[list.size()];
		pID         = new int[list.size()];
		
			for(int j = 0; j<= list.size()-1;j++){
				
				pID[j]          = id;
				arrivalTime[j]  = arrival;
				burstTime[j]    = burst;
				
			}
		
		
			process.add(new Que(id, arrival, burst));
			
	}
	
	
	for(int m = 0; m <= process.size() -1 ; m++){
			sch(process);
//		
//		if(process.get(m).getArrive() == 0){
//				//(new Scheduler(d)).start();
//				System.out.println(process.get(m).getArrive());
//		}
//	
	}
	
		
	
	
	
}
	

public static void sch(List <Que> process){
	
	sorted.add(new Que(process.get(0).getId(), process.get(0).getArrive(), process.get(0).getBurst()));

			
	
	}
	
	
	
public static void sortNow(){
	int on      = process.size();
	int timer   = 0;
	int quantum = 3;
	 
	while(process.isEmpty() != true){
		
		//Sorting for next up in que
		Scheduler pNow = new Scheduler();
		Thread p1 = new Thread(pNow);
		int idNow  = process.get(0).getId();
		int nextUp = process.get(0).getArrive();
		
			for(int i = 1; i < process.size(); i++){
				if(process.get(i).getArrive() < nextUp){
					nextUp = process.get(i).getArrive();
				}	idNow    = process.get(i).getId();
				
				
				
			
			
			
			
			//System.out.println("next up: " + nextUp + "id: " + idNow);
			
			
			//give it job amount of process 
					for(int j = 0; j<= process.size() - 1; j++){
						
						if(process.get(j).getArrive() == nextUp){
							
							int newBurst = 0;
							 	while(timer < quantum){
							 		timer++;
							 		System.out.println("Processing job: " + process.get(j).getId() + " Quantum Timer: " + timer);
							 		
							 		p1.start();
							 	}
							 	
							 	//reset arrive to push back onto que
							 	on++;
							 	
							 	 process.get(j).setArrive(on);
								 newBurst = (process.get(j).getBurst() - timer);
								 process.get(j).setBurst(newBurst);
								 System.out.println("Burst Time left: " + newBurst);
								
								 if(newBurst < 0){
									 
									 process.remove(process.get(j)); 
								 }
								System.out.println("Closing. Next process" );
								timer = 0;
						}
							
					}
			}
	}
		
}

		
//		if(process.get(i).getArrive() == 0){
//			
//			
//			//start
//		}else if( process.get(i).getArrive() < process.get(k + 1).getArrive()){
//			
//			//keep going 
//			
//			
//		}
		
		
		
//		int temp;
//		
//	for(int i = 0; i <= process.size() - 1; i++){
//		
//		q.add(process.get(i).getArrive());
//		
//	}	
//		for(int j = 0; j <= process.size() - 1; j++){
//			
//			  temp    = q.remove();
//			  System.out.println(temp);
//			 
//			  numbers[j] = temp;
//		}
//	 	
//		System.out.println(q.remove());		
//		System.out.println(q.remove());	
//		System.out.println(q.remove());
//		System.out.println(q.remove());
//		
//		System.out.println(q.size());	
//		

			
				
			
			
	
	
	

	
	
public static void readIn(){
		

		String incoming     = "src/round.csv";
		String line         = "";
		BufferedReader read = null;
		
		
		
		try{
			
			read = new BufferedReader(new FileReader(incoming));
			
					while((line = read.readLine()) != null){
						
							lines.add(line);
							
							
					}
						breakUp(lines);
						//printOut();
						
			
		}catch(FileNotFoundException e){
			
				e.printStackTrace();
			
		}catch(IOException e){
			
				e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	

public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		readIn();
		sortNow();
		
		
		
		
	}

}
