import java.util.*;


public class GClass {
	public static final Scanner sc = new Scanner(System.in);
	
	public static ArrayList<Instructor> Ilist = new ArrayList<>();
	
	public static ArrayList<Slides> SlideL = new ArrayList<>();
	
	public static ArrayList<Lvideos> Lvlist = new ArrayList<>();
	
	public static ArrayList<Student> Slist = new ArrayList<>();
	
	public static ArrayList<String> CList = new ArrayList<>();
	
	public static ArrayList<Assignment> AList = new ArrayList<>();
	
	public static void main(String args[]) {
		Users user = new Users();
		String choice= "0";
		int iid = -1;
		String ichoice = "0";
		String achoice = "0";
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
		while(!choice.equals("3")) {
			System.out.print("\nWelcome to Backpack\n1. Enter as instructor\n"
					+ "2. Enter as student\n"
					+ "3. Exit\n");
			choice = sc.nextLine();
			switch(choice) {
			case "1":
				System.out.print("Instructors:\n"
						+ "0 - I0\n"
						+ "1 - I1\n");
				System.out.println("Choose id:");
				iid = Integer.parseInt(sc.nextLine());
				ichoice = "0";
				while(!ichoice.equals("9")) {
					System.out.println("Welcome I" + iid);
					System.out.print("1. Add class material\n"
							+ "2. Add assessments\n"
							+ "3. View lecture materials\n"
							+ "4. View assessments\n"
							+ "5. Grade assessments\n"
							+ "6. Close assessment\n"
							+ "7. View comments\n"
							+ "8. Add comments\n"
							+ "9. Logout\n");
					ichoice = sc.nextLine();
					switch(ichoice) {
					case "1":
						System.out.println("1.Add Lecture Slide");
						System.out.println("2.Add Lecture Video");
						achoice = sc.nextLine();
						switch(achoice){
							case "1":
								achoice = "0";
								Ilist.get(iid).addLSlide();
								break;
							case "2":
								achoice = "0";
								Ilist.get(iid).addLVid();
								break;
							default:
								achoice = "0";
								System.out.println("Wrong Choice");
								break;
						}
						break;
					case "2":
						System.out.println("1. Add Assignment\n"
								+ "2. Add Quiz");
						achoice = sc.nextLine();
						switch(achoice){
							case "1":
								achoice = "0";
								Ilist.get(iid).addAssign("0");
								break;
							case "2":
								achoice = "0";
								Ilist.get(iid).addAssign("1");
								break;
							default:
								achoice = "0";
								System.out.println("Wrong Choice");
								break;
						}
						break;
					case "3":
						user.viewLecture();
						break;
					case "4":
						user.viewAssessments();
						break;
					case "5":
						Ilist.get(iid).aMarks();
						break;
					case "6":
						Ilist.get(iid).listOpenA();
						break;
					case "7":
						user.viewComments();
						break;
					case "8":
						Ilist.get(iid).addComment();
						break;
					case "9":
						System.out.println(Ilist.get(iid).getname() + " Logged out");
						break;
					default:
						System.out.println("Wrong Choice");
						break;
					}
				}
                break;
			case "2":
				ichoice = "0";
				System.out.println("Students:\n"
						+ "0 - S0\n"
						+ "1 - S1\n"
						+ "2 - S2");
				System.out.print("Choose id:");
				iid = Integer.parseInt(sc.nextLine());
				while(!ichoice.equals("7")) {
					System.out.println("Welcome S" + iid);
					System.out.println("1. View lecture materials\n"
							+ "2. View assessments\n"
							+ "3. Submit assessment\n"
							+ "4. View grades\n"
							+ "5. View comments\n"
							+ "6. Add comments\n"
							+ "7. Logout");
					ichoice = sc.nextLine();
					switch(ichoice) {
					case "1":
						user.viewLecture();
						break;
					case "2":
						user.viewAssessments();
						break;
					case "3":
						Slist.get(iid).submit(iid);
						break;
					case "4":
						Slist.get(iid).viewGrades(iid);
						break;
					case "5":
						user.viewComments();
						break;
					case "6":
						Slist.get(iid).addComment();
						break;
					case "7":
						System.out.println(Slist.get(iid).getname() + " Logged out");
						break;
					default:
						System.out.println("Wrong Choice");
						break;	
					}
				}
                break;
			case "3":
				System.out.println("Close Backpack");
				break;
            default:
                System.out.println("Wrong Choice");
                break;
			}
		}
	}
}