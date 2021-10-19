import java.util.*;
public class Assignment implements Assessment {
	private String status;
	private String problem;
	public int max;
	private String type;
	ArrayList<Integer> submission = new ArrayList<>();
	ArrayList<Integer> gradstatus = new ArrayList<>();
	ArrayList<String> sub = new ArrayList<>();
	ArrayList<Integer> grade = new ArrayList<>();
	ArrayList<String> grader = new ArrayList<>();
	
	public Assignment(String problem, String type,int max) {
		this.status = "OPEN";
		this.problem = problem;
		this.type = type;
		for(int i = 0; i<3; i++) {
			submission.add(0);
			gradstatus.add(0);
			sub.add("0");
			grade.add(0);
			grader.add("0");
		}
	}
	
	public void chStatus() {
		this.status = "CLOSED";
	}
	
	public String getstatus() {
		return this.status;
	}
	
	public String gettype() {
		return type;
	}
	
	public String getprob() {
		return problem;
	}
	
	public int getmax() {
		return max;
	}
	
	@Override
	public void grade(int id, int marks, String grader) {
		this.grade.set(id, marks);
		this.grader.set(id, grader);
		this.gradstatus.set(id, 1);
	}
	
}
