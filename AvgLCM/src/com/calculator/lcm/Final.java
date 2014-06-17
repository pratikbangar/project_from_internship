package com.calculator.lcm;

import javax.naming.LimitExceededException;

public class Final {
	public static void main(String[] args) throws LimitExceededException {
		try {
			LcmCalculator A = new LcmCalculator();
			System.out.println("A(n)=" + A.calculateAverage(Integer.parseInt(args[0])));
		} catch (NegativeNoException e1) {
			System.out.println("Please enter a positive no.");
		} catch (NumberFormatException e2) {
			System.out.println("Please enter a integer no.");
		} catch (ArrayIndexOutOfBoundsException e3) {
			System.out.println("Please enter a no.");
		}
	}
}
