import java.util.Scanner;

                       public class Welcome{
                               public static void main(String[]args){

                       Scanner input = new Scanner(System.in);
                       System.out.print("enter your first name:");
                       String firstName = input.nextLine();

                       System.out.print("enter your last name:");
                       String lastName = input.nextLine();

                       System.out.println("welcome to the second year"+ firstName +""+ lastName);

                       input.close();
               }
}


