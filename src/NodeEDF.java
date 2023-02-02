
public class NodeEDF extends Node {
	
	NodeEDF(int bitRate) {
		super(bitRate);
		sending = false;
	}

	//Adds new node sorted by the deadline from smallest to biggest.
	protected void newNode(Packet p,int time) {
		p.arrivalTimes.add(time);
		for(int i = queue.size()-1; i > -1; i--) {
			if (p.deadline >= queue.get(i).deadline) {
				queue.add(i+1, p);
		        break;
			}
			if(i == 0) {
				queue.add(i , p);
			}
		}
		if(queue.isEmpty())
			queue.add(p);
	}
	
	public String toString() {
		return "NodeB: " + super.toString();
	}

}
