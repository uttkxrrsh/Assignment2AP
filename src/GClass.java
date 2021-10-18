import java.util.*;


public class GClass {
	public static final Scanner sc = new Scanner(System.in);
	
	public static ArrayList<Instructor> Ilist = new ArrayList<>();
	
	public static ArrayList<Student> Slist = new ArrayList<>();
	
	public static void main(String args[]) {
		Instructor i0 = new Instructor("I0");
		Instructor i1 = new Instructor("I1");
		Ilist.add(i0);
		Ilist.add(i1);
		
		Student s0 = new Student("S0");
		Student s1 = new Student("S1");
		Student s2 = new Student("S2");
		Slist.add(s0);
		Slist.add(s1);
		Slist.add(s2);
		
		String choice= "0";
		System.out.println("\nWelcome to Backpack\n1.Enter as instructor\n"
				+ "2. Enter as student\n"
				+ "3. Exit\n");
		choice = sc.nextLine();
		while(choice != "3") {
			switch(choice) {
			case "1":
				System.out.println("Instructors:\n"
						+ "0 - I0\n"
						+ "1 - I1\n");
				System.out.println("Choose id:");
				String id;
				id = sc.nextLine();
				switch(id) {
				case "1":
					System.out.println("1. Add class material\n"
							+ "2. Add assessments\n"
							+ "3. View lecture materials\n"
							+ "4. View assessments\n"
							+ "5. Grade assessments\n"
							+ "6. Close assessment\n"
							+ "7. View comments\n"
							+ "8. Add comments\n"
							+ "9. Logout");
					
				}
			}
				
		}
	}
}
