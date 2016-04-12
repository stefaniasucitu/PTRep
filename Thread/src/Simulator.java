
/*import java.io.Console;
 * import java.util.Scanner;*/

import java.io.IOException;

public class Simulator implements Runnable {
	
	private static Scheduler s;
	private SimulatorFrame frame;

	public Simulator(int lim, int min, int max) {
		s = new Scheduler();
		frame = new SimulatorFrame();
	}

	public void run() {

		int currentTime = 0;
		while (currentTime < SimulatorFrame.limit) {
			currentTime++; // 5 min
			int procTime = (int) (Math.random() * (SimulatorFrame.maxProcTime - SimulatorFrame.minProcTime) + SimulatorFrame.minProcTime);
			Task t = new Task(currentTime, procTime);
			try {
				s.dispatchTaskOnServers(t);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			frame.displayData1(s.getServer(0).getTask());
			frame.displayData2(s.getServer(1).getTask());
			frame.displayData3(s.getServer(2).getTask());
			frame.displayData4(s.getServer(3).getTask());
			frame.displayData5(s.getServer(4).getTask());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("nr tasks:    Average time:");
		for (int i = 0; i < 5; i++) {

			
			System.out.print(s.getServer(i).getTasknr() + " ");
			System.out.print(" " + s.getServer(i).getAverageTime() + " ");
			System.out.println();
		}

	}

	public static void main(String[] args) {
		
		new SimulatorFrame();

	}

}
