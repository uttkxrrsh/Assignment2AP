
public class Instructor extends Users {
	private String name;
	
	public Instructor(String name){
		this.name = name;
	}
	
	public void addLSlide() {
		int n;
		String topic;
		System.out.print("Enter topic of slides:");
		topic = GClass.sc.nextLine();
		System.out.print("Enter no of slides:");
		n = Integer.parseInt(GClass.sc.nextLine());
		Slides slide= new Slides(n,topic,name);
		GClass.SlideL.add(slide);
	}
	
	public void addLVid() {
		String topic;
		String filename;
		System.out.print("Enter topic of video:");
		topic = GClass.sc.nextLine();
		System.out.print("Enter filename of video:");
		filename = GClass.sc.nextLine();
		Lvideos l = new Lvideos(topic, filename,name);
		if(!l.typeFile(filename)) {
			System.out.println("Wrong Filetype");
		}
		else {
			GClass.Lvlist.add(l);
		}
	}
	
	public void addComment() {
		String c;
		System.out.print("Enter comment: ");
		c = GClass.sc.nextLine();
		c = c + " - "+ this.name + "\n" + getTimeStamp();
		GClass.CList.add(c);
	}
	
	public void addAssign(String type) {
		String problem;
		int max;
		if(type.equals("0")) {
			System.out.print("Enter problem statement: ");
			problem = GClass.sc.nextLine();
			System.out.print("Enter max marks: ");
			max = Integer.parseInt(GClass.sc.nextLine());
			Assignment a = new Assignment(problem,type,max);
			GClass.AList.add(a);
		}
		else {
			System.out.print("Enter quiz question: ");
			problem = GClass.sc.nextLine();
			max = 1;
			Assignment b = new Assignment(problem,type,max);
			GClass.AList.add(b);
		}
	}
	
	public void aMarks() {
		int choice;
		int flag = 0;
		int id;
		int marks;
		this.viewAssessments();
		System.out.print("Enter ID of assessment to view submissions: ");
		choice = Integer.parseInt(GClass.sc.nextLine());
		System.out.println("Choose ID from these ungraded submissions");
		for(int i = 0; i<3; i++) {
			if(GClass.AList.get(choice).submission.get(i) == 1 && GClass.AList.get(choice).gradstatus.get(i) == 0) {
				System.out.println(i+". S"+i);
				flag =1;
			}
		}
		if(flag == 0) {
			System.out.println("No Submissions for this Assignment");
		}
		else {
			id = Integer.parseInt(GClass.sc.nextLine());
			System.out.println("Submission:");
			System.out.println("Submission: " + GClass.AList.get(choice).sub.get(id));
			System.out.println("-------------------------------");
			System.out.println("Max Marks: "+ GClass.AList.get(choice).getmax());
			System.out.println("Marks scored: ");
			marks = Integer.parseInt(GClass.sc.nextLine());
			GClass.AList.get(choice).grade(id, marks, this.name);
		}
	}
	
	public void listOpenA() {
		int flag = 0;
		int id;
		for(int i = 0; i<GClass.AList.size(); i++) {
			if(GClass.AList.get(i).gettype().equals("0") && GClass.AList.get(i).getstatus().equals("OPEN")) {
				System.out.println("ID: "+ i +" Assignment: "+ GClass.AList.get(i).getprob()+" Max Marks: " + GClass.AList.get(i).getmax());
				System.out.println("-------------------------------");
				flag = 1;
			}
			else if(GClass.AList.get(i).gettype().equals("1") && GClass.AList.get(i).getstatus().equals("OPEN")) {
				System.out.println("ID: "+ i +" Question: "+ GClass.AList.get(i).getprob());
				System.out.println("-------------------------------");
				flag = 1;
			}
			if(flag == 0) {
				System.out.println("No Open Assignments");
			}
			else {
				System.out.print("Enter id of assignment to close: ");
				id = Integer.parseInt(GClass.sc.nextLine());
				GClass.AList.get(id).chStatus();
			}
		}
	}
	
	public String getname() {
		return this.name;
	}
}
