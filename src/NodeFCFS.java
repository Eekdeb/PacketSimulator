/**
 * This node has the scheduling of First Come First Serve
 * @author Eek de Bruijckere
 */
public class NodeFCFS extends Node {

	NodeFCFS(int bitRate) {
		super(bitRate);
	}

	//Adds new node to the back of the queue and saves arrival time
	protected void newNode(Packet p,int time) {
		p.arrivalTimes.add(time);
		queue.add(p);
	}
	
	public String toString() {
		return "NodeA: " + super.toString();
	}

}
