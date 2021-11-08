package edu.umb.cs680.hw01;
public class Calculator {
	public double Addition(double x,double y) {
		return (x+y);
	}
	
	public double Subtraction(double x,double y) {
		return (x-y);
	}
	
	public double Multiply(double x,double y) {
		return (x*y);
	}
	
	public double Division(double x, double y) {
		if(y==0) {
			throw new IllegalArgumentException("Undefined!!");
		}else {
			return (x/y);
		}
		
	}

	public static void main(String[] args) {
		Calculator calculator= new Calculator();
		System.out.println("value is " +calculator.Addition(4, 6));
		System.out.println("value is " +calculator.Subtraction(4, 6));
		System.out.println("value is " +calculator.Multiply(4, 6));
		System.out.println("value is " +calculator.Division(4, 2));
		System.out.println("value is " +calculator.Division(4, 0));

	}
}