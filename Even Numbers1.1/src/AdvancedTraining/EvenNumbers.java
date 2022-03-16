package AdvancedTraining;
import java.util.Scanner;

public class EvenNumbers { 
	int UserInput;
	 public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the user input:");
		 int UserInput=sc.nextInt();
		 for(int i=0;i<=UserInput;i++) {
			 if(i%2==0&i<=UserInput) {
				 System.out.println(" "+i+" ");
			 }
		 }
			
	 }

}
