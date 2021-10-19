import java.util.*;

public class Slides extends Material {
	ArrayList<String> content = new ArrayList<>();
	String topic;
	String upload;
	String inst;
	int num;
	public Slides(int n,String topic,String inst) {
		String c;
		this.num = n;
		this.upload = getTimeStamp() + "IST 2021";
		this.topic = topic;
		this.inst = inst;
		for(int i = 0; i<n; i++) {
			System.out.print("Content of slide " + i + ": ");
			c = GClass.sc.nextLine();
			content.add(c);
		}
	}
}
