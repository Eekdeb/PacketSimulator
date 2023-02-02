import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class NodeSave extends Node {
	
	File file;
	FileWriter fr;

	NodeSave(int bitRate, String filename) {
		super(bitRate);
		file = new File("filename");
	}
	
	@Override
	void send(Node n, int time) {		
	}

	//when a new node is added it is saved in a txt document
	// arrivaltimes if(deadline is pased)
	protected void newNode(Packet p,int time) {
		p.arrivalTimes.add(time);
		String save = p.arrivalTimes.toString();
		save = save.replace(',', ' ');
		save = save.replace('[', ' ');
		save = save.replace(']', ' ');
		save += "" + (p.deadline <= time);
		try {
			fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(save + "\n");
	
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		queue.add(p);
	}
	
	public String toString() {
		return "NodeC: " + super.toString();
	}
}
