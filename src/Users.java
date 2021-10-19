import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Users{
	
	public Users() {
		Instructor i0 = new Instructor("I0");
		Instructor i1 = new Instructor("I1");
		GClass.Ilist.add(i0);
		GClass.Ilist.add(i1);
		
		Student s0 = new Student("S0");
		Student s1 = new Student("S1");
		Student s2 = new Student("S2");
		GClass.Slist.add(s0);
		GClass.Slist.add(s1);
		GClass.Slist.add(s2);
	}
	
	protected String getTimeStamp() {
		Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");  
        String s = formatter.format(ts);
        return s;
	}
	
	
	public void viewLecture() {
		// TODO Auto-generated method stub
		int flag = 0;
		for(Slides x: GClass.SlideL) {
			System.out.println();
			System.out.println("Title: " + x.topic);
			for(int i = 0; i<x.content.size(); i++) {
				System.out.println("Slide "+ i + x.content.get(i));
			}
			System.out.println("Number of Slides: "+ x.num);
			System.out.println("Date of upload: "+ x.upload);
			System.out.println("Uploaded by: " + x.inst);
			flag = 1;
		}
		for(Lvideos x: GClass.Lvlist) {
			System.out.println();
			System.out.println("Title of video: "+ x.topic);
			System.out.println("Video File: "+ x.filename);
			System.out.println("Date of upload: "+ x.upload);
			System.out.println("Uploaded by: "+ x.inst);	
			flag = 1;
		}
		if(flag == 0) {
			System.out.println("No Lecture Material available");
		}
	}
	
	public void viewAssessments() {
		for(int i = 0; i<GClass.AList.size(); i++) {
			if(GClass.AList.get(i).gettype().equals("0")) {
				System.out.println("ID: "+ i +" Assignment: "+ GClass.AList.get(i).getprob()+" Max Marks: " + GClass.AList.get(i).getmax());
				System.out.println("----------------");
			}
			else {
				System.out.println("ID: "+ i +" Question: "+ GClass.AList.get(i).getprob());
				System.out.println("----------------");
			}
		}
	}
	
	public void viewComments() {
		int flag = 0;
		for(String x: GClass.CList) {
			System.out.println(x);
			flag = 1;
		}
		if(flag == 0) {
			System.out.println("No Commnets Added");
		}
	}

	
	
	
}
