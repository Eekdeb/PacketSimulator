import java.util.List;
import java.util.ArrayList;

public class Packet {
	
	int length;
	int deadline;
	List<Integer> arrivalTimes;
	
	
	Packet(int length,int deadline) {
		this.length = length;
		this.deadline = deadline;
		arrivalTimes = new ArrayList<Integer>();;
	}
}
