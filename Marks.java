import java.util.Scanner;

public class Marks{
	public static void main(String[] args){
		int studentId,subjectId;
		boolean running = true;

		Scanner input = new Scanner(System.in);	
		System.out.print("Enter the number of students in the Class: ");
		int n = input.nextInt();
		//init the mark array
		int[][] marks = new int[n][3];
		//showcase the menu to the user
		while(running){
		System.out.println("1. Add student marks");
		System.out.println("2. Update student marks");
		System.out.println("3. Average for a subject");
		System.out.println("4. Average for a student");
		System.out.println("5. Total marks of a student");
		System.out.println("6. Dispaly grades");
		System.out.println("7. Exit");

		System.out.print("Choose an option:");
		int option = input.nextInt();
		switch(option){
			case 1:
				do{
					System.out.print("Enter the Student Id: ");
					studentId =input.nextInt(); 

				}while(studentId>n || studentId<1);
				add(studentId,marks);
				break;
			case 2:
                                do{
                                        System.out.print("Enter the Student Id you need to update: ");
                                        studentId =input.nextInt(); 

                                }while(studentId>n || studentId<1);
                                update(studentId,marks);
                                break; 
			case 3:
				System.out.print("Enter the subject Id(1.Mathematics,2.Chemistry,3.Physics): ");
				subjectId = input.nextInt();
				System.out.println("Average mark is "+ average(marks,subjectId));
				break;
			case 4:
                                do{
                                        System.out.print("Enter the Student Id: ");
                                        studentId =input.nextInt(); 
                                }while(studentId>n || studentId<1);
		                System.out.println("average marks of the student "+ studentId +" : "+ averageStd(marks,studentId));
				break;
			case 5:
				do{
                                        System.out.print("Enter the Student Id: ");
                                        studentId =input.nextInt();
					if(studentId > n || studentId < 1){
						System.out.println("Enter valid Id!");
					} 

                                }while(studentId>n || studentId<1);

                                System.out.println("Total marks of the student "+ studentId +" : "+total(studentId,marks));
                                break;
			case 6:
				displayGrades(marks);
				break;
			case 7:
				running = false;
				break;
		}
	    }

	}

	public static void add(int studentId,int[][] arr){
		Scanner input = new Scanner(System.in);
		String[] subjects = {"Mathematics","Chemistry","Physics"};
		for(int i=0;i<3;i++){
			System.out.print("Enter marks for "+ subjects[i]+": " );
			arr[studentId-1][i] = input.nextInt();
		}
	}



        public static void update(int studentId,int[][] arr){
                Scanner input = new Scanner(System.in);
                String[] subjects = {"Mathematics","Chemistry","Physics"};
                for(int i=0;i<3;i++){
                        System.out.print("Enter marks for "+ subjects[i]+ ": " );
                        arr[studentId-1][i] = input.nextInt();
                }
        }
	public static float average(int[][] arr,int subjectId){
		float  marks = 0;
		int count = 0;

		for(int i = 0; i < arr.length ; i++){
			marks += arr[i][subjectId-1];
			count ++;
			
		}
		return (marks/count);

	}

        public static int total(int studentId, int[][] arr){
		int total = 0;
                for(int i=0;i<3;i++){
                        total += arr[studentId-1][i];
                }
		return total;
        }

	public static float averageStd(int[][] arr,int studentId){
                float  marks = 0 ;
                int count = 0;
		
                for(int i = 0; i < 3 ; i++){
                            marks += arr[studentId-1][i];
                            count ++;
                }
                return (marks/count);
        }

	public static String getGrade(int mark){
		if(mark >= 90){
			return "Grade A";
		}
		else if(mark >= 80){
			return "Grade B";
		}
		else if(mark >= 70){
			return "Grade C";
		}
		else if(mark >= 60){
			return "Grade D";
		}
		else{
			return "Fail";
		}
	}

	public static void displayGrades(int[][] arr){
		String[] subjects = {"Mathematics","Chemistry","Physics"};
		System.out.println();
		System.out.printf("%-10s%-15s%-15s%-15s%n","Student","Mathematics","Chemistry","Physics");
		System.out.println("---------------------------------------------------------------");
		for(int i = 0; i < arr.length; i++){
			System.out.printf("%-10d", i + 1);
			for(int j = 0; j < 3; j++){
				System.out.printf("%-15s", getGrade(arr[i][j]));
			}
			System.out.println();
		}
	}
}
