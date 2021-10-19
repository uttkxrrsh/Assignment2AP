
public class Lvideos extends Material {
	String topic;
	String filename;
	String inst;
	String upload;
	public Lvideos(String topic, String filename,String inst) {
		this.topic = topic;
		this.filename = filename;
		this.inst = inst;
		this.upload = getTimeStamp() + "IST 2021";
	}
	
	
	public boolean typeFile(String filename) {
		int size = filename.length();
		if(filename.substring(size-4).equals(".mp4")) {
			return true;
		}
		return false;
	}
	
}
