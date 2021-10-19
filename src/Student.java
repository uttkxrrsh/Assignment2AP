
public class Student extends Users {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	public void addComment() {
		String c;
		System.out.print("Enter comment: ");
		c = GClass.sc.nextLine();
		c = c + " - "+ this.name + "\n" + getTimeStamp() + " 2021";
		GClass.CList.add(c);
	}
	
	public String getname() {
		return this.name;
	}
	
	public void submit(int id) {
		int choice;
		String type;
		String sol;
		int flag = 0;
		System.out.println("Pending assessments");
		for(int i = 0; i<GClass.AList.size(); i++) {
			if(GClass.AList.get(i).gettype().equals("0") && GClass.AList.get(i).submission.get(id)==0 && GClass.AList.get(i).getstatus().equals("OPEN")) {
				System.out.println("ID: "+ i +" Assignment: "+ GClass.AList.get(i).getprob()+" Max Marks: " + GClass.AList.get(i).getmax());
				flag = 1;
			}
			else if(GClass.AList.get(i).gettype().equals("1") && GClass.AList.get(i).submission.get(id)==0 && GClass.AList.get(i).getstatus().equals("OPEN")) {
				System.out.println("ID: "+ i +" Question: "+ GClass.AList.get(i).getprob());
				flag = 1;
			}
		}
		if(flag == 0) {
			System.out.println("No Pending Assessments");
		}
		else {
			System.out.print("Enter ID of assessment: ");
			choice = Integer.parseInt(GClass.sc.nextLine());
			type = GClass.AList.get(choice).gettype();
			if(type.equals("0")){
				System.out.print("Enter filename of assignment: ");
				sol = GClass.sc.nextLine();
				if(sol.substring(sol.length()-4).equals(".zip")) {
					GClass.AList.get(choice).sub.set(id, sol);
					GClass.AList.get(choice).submission.set(id, 1);
				}
				else {
					System.out.println("Wrong filetype");
				}
			}
			else {
				System.out.print(GClass.AList.get(choice).getprob());
				sol = GClass.sc.nextLine();
				GClass.AList.get(choice).sub.set(id, sol);
				GClass.AList.get(choice).submission.set(id, 1);
			}
		}
	}
	
	public void viewGrades(int id) {
		System.out.println("Graded submissions");
		for(Assignment a : GClass.AList) {
			if(a.gradstatus.get(id) == 1) {
				System.out.println("Submission: "+ a.sub.get(id)+ "\n"
						+ "Marks scored: "+ a.grade.get(id) +"\n"
						+ "Graded by: " + a.grader.get(id));
			}
		}
		System.out.println("Ungraded submissions");
		for(Assignment a : GClass.AList) {
			if(a.gradstatus.get(id) == 0 && a.submission.get(id) == 1) {
				System.out.println("Submission: "+ a.sub.get(id)+ "\n");
			}
		}
	}
}
