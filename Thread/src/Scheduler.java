import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.concurrent.atomic.AtomicInteger;

public class Scheduler {

	private Server[] Servers;
	private AtomicInteger timelimit = new AtomicInteger(16);
	
	public Scheduler() {
	
		Servers = new Server[5];
		for (int i = 0; i < 5; i++) {
			Servers[i] = new Server();
			Thread th = new Thread(Servers[i]);
			th.start();
		}
	}

	void dispatchTaskOnServers(Task t) throws IOException {
		int nr = 1;
		int ServNr = 0;
		int min = 16;
		System.out.println(Servers[0].getTime().get() + " " + Servers[1].getTime().get() + " "
				+ Servers[2].getTime().get() + " " + Servers[3].getTime().get() + " " + Servers[4].getTime().get());

		for (int i = 0; i < nr; i++) {
			if ((Servers[i].getTime().get() + t.getProcessTime()) >= timelimit.get()) {
				if (nr < 5)
					nr++;
			} else if (Servers[i].getTime().get() < min) {
				min = Servers[i].getTime().get();
				ServNr = i;
			}
		}
		
		Servers[ServNr].addTask(t);
		String fileName = "out.txt";
		try {
			FileWriter outputStream = new FileWriter(fileName,true);
			outputStream.append(" Task AT:"+t.getArrivalTime() +" PT:"+ t.getProcessTime()+" on Server:"+ServNr+"\n");
			outputStream.write("\n");
			outputStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public Server getServer(int nr) {
		return Servers[nr];
	}

}
