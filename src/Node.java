import java.util.LinkedList;

/**
 * This is a base node that transfers packets with specific bit rate
 * to another node.
 * @author Eek de Bruijckere
 */
public abstract class Node {
	
	Packet sendingPacket;
	boolean sending;

	LinkedList<Packet> queue = new LinkedList<Packet>();
	int bitRate; //bits is sent at a time
	int sendCounter; //sent bits
	
	/**
	 * Base node
	 * @param bitRate This is for amount of data can be sent every 
	 * time unit.
	 */
	Node(int bitRate) {
		this.bitRate = bitRate;
		sendCounter = 0;
	}
	
	/**
	 * Sending parts of the first packet in the queue to node n.
	 * According to the bit rate it will take some time to send a packet. 
	 * Ex packet length = 5 bitrate = 1 need to call send 5 times to send.
	 * @param n: the node sent to.
	 */
	void send(Node n, int time) {
		if(!sending && !queue.isEmpty()){
			sending = true;
			sendingPacket = queue.poll();
		}
		if(sending) {
			if(sendingPacket.length > sendCounter + bitRate) {
				sendCounter += bitRate;
			}
			else {
				sending = false;
				sendCounter = 0;
				n.newNode(sendingPacket,time);
			}
		}			
	}
	
	protected abstract void newNode(Packet p, int time);
	
	@Override
    public String toString() {
		if(sending)
			return  "length:" + sendingPacket.length + " sendCount:" + sendCounter + " Packets:" + (queue.size()+1);
		if(!queue.isEmpty())
			return  "Packets:" + (queue.size());
		return "Empty";
    }
}
