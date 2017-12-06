package robin;

public class Que {
	
	private int burst;
	private int  id;
	private int  arrive;
	
	int front;
	int end;
	
	public Que(int id, int arrive, int burst){
		
		this.arrive = arrive;
		this.burst  = burst;
		this.id     = id;
		this.front  = 0;
		this.end    = 0;
		
	}
	
	public Integer getBurst(){
		
		return burst;
	}
	
	public void setBurst(int burst){
		
		this.burst = burst;
	}
	
	public Integer getId(){
		
		return id;
	}
	
	public void setId(int id){
		
		this.id = id;
	}
	
	public Integer getArrive(){
		
		return arrive;
	}
	public void setArrive(int arrive){
		this.arrive = arrive;
	}
	
}
