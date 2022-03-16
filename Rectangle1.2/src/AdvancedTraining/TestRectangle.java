package AdvancedTraining;

import java.util.Scanner;

public class TestRectangle {
	Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestRectangle().rect1(0, 0);
		new TestRectangle().rect2(0, 0);
		new TestRectangle().rect3(0, 0);
		new TestRectangle().rect4(0, 0);
		new TestRectangle().rect5(0, 0);

	}
	
	void rect1(int length, int breadth) {
		
		System.out.println("Enter the length:");
		length =sc.nextInt();
		System.out.println("Enter the breadth :");
		breadth=sc.nextInt();
		System.out.println("The area of rectangle is "+(length*breadth));
		
		
	}
	void rect2(int length,int breadth) {
		System.out.println("enter the length:");
		length =sc.nextInt();
		System.out.println("enter the breadth :");
		breadth=sc.nextInt();
		System.out.println("the area of rectangle is "+(length*breadth));
		
		
	}
	void rect3(int length,int breadth) {
		System.out.println("enter the length:");
		length =sc.nextInt();
		System.out.println("enter the breadth :");
		breadth=sc.nextInt();
		System.out.println("the area of rectangle is "+(length*breadth));
		
		
	}
	void rect4(int length,int breadth) {
		System.out.println("enter the length:");
		length =sc.nextInt();
		System.out.println("enter the breadth :");
		breadth=sc.nextInt();
		System.out.println("the area of rectangle is :"+(length*breadth));
		
		
	}
	void rect5(int length,int breadth) {
		System.out.println("enter the lenth:");
		length =sc.nextInt();
		System.out.println("enter the breath :");
		breadth=sc.nextInt();
		System.out.println("the area of rectangle is "+(length*breadth));
		
		
	}

}