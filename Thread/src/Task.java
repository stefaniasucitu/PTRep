
public class Task {
	private int arrivalTime;
	private int processTime;
	public Task(int arr, int proc){
		this.arrivalTime=arr;
		this.processTime=proc;
	}
	int getArrivalTime(){
		return this.arrivalTime;
	}
	int getProcessTime(){
		return this.processTime;
	}
	
	void setArrivalTime( int i){
		this.arrivalTime=i;
	}
	void setProcessTime(int i){
		this.processTime=i;
	}
	@Override
	public String toString(){
		return ("AT:"+arrivalTime +" PT:"+ processTime);
		
	}
	
}
