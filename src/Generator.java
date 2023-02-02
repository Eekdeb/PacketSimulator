/**
 * This class creates packets for every period
 * @author Eek de Bruijckere
 */
public class Generator {
	
	int period,size,toDeadline;
	Node n;
	
	/**
	 * @param n: the node packets will be generated in
	 * @param period: how often a new packet is generated
	 * @param size: size of a packet
	 * @param toDeadline
	 */
	public Generator(Node n, int period, int size, int toDeadline) {
		this.period = period;
		this.n = n;
		this.size = size;
		this.toDeadline = toDeadline;
	}

	/**
	 * This generates the packets when needed. 
	 * Needs to be run every time unit.
	 * @param time: the current time
	 */
	public void update(int time) {
		if(time%period == 0) {
			n.newNode(new Packet(size, toDeadline+time),time);
		}
	}
}
