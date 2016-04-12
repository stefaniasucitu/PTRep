
import java.util.concurrent.LinkedBlockingQueue;

import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
	private LinkedBlockingQueue<Task> queue= new LinkedBlockingQueue<Task>();
	private AtomicInteger waitingTime;
	private AtomicInteger serviceTime;
	private AtomicInteger TotalProcTime;

	private int nrTasks;
	

	
	public Server(){
		waitingTime=new AtomicInteger(0);
		serviceTime=new AtomicInteger(0);
		TotalProcTime=new AtomicInteger(0);
		nrTasks=0;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			Task currT = null;
			try {
				currT = queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(currT.getProcessTime() *1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitingTime.addAndGet((-1)*currT.getProcessTime());
			
		}

	}
	public void addTask(Task t)
	{
		queue.add(t);
		waitingTime.addAndGet(t.getProcessTime());
		if (waitingTime.get()!=0){
			
		}	
		
		TotalProcTime.addAndGet(t.getProcessTime());
		nrTasks++;
	}
	public Task[] getTask(){
		Task[] tasks=new Task[queue.size()];
		queue.toArray(tasks);
		return tasks;
	}
	public AtomicInteger getTime(){
		return this.waitingTime;
	}
	public AtomicInteger getServiceTime(){
		return this.serviceTime;
	}
	public int getAverageTime(){
		if (this.nrTasks>0)
		return (this.TotalProcTime.get()/this.nrTasks);
		else return (this.TotalProcTime.get()/1);
	}
	public int getTasknr(){
		
		return this.nrTasks;
		
	}
}
