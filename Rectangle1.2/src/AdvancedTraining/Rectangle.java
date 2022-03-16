package AdvancedTraining;

import java.util.Scanner;

public class Rectangle {
static	int length;
static	int breadth;
Scanner sc=new Scanner(System.in);
	

	public static void main(String[] args) {
	   new Rectangle().AreaOfRectangle();
		
		
		
		

	}
	void AreaOfRectangle() {
System.out.println("enter the length of the  rectangle");
		 length=sc.nextInt();
		 
		 System.out.println("enter the breadth of the rectangle");
		 breadth=sc.nextInt();
		 int Area=length*breadth;
		 System.out.println("the area of the rectangle is :"+Area);
		 System.out.println("the length of the rectangle is:"+length);
		 System.out.println("the breadth of the rectangle is:"+breadth);
		
		
		
	}

}