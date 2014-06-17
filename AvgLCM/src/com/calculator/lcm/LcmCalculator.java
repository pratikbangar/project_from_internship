package com.calculator.lcm;

import javax.naming.LimitExceededException;

public class LcmCalculator {

	public long calculate(int a, int b) throws LimitExceededException {
		int m = Math.max(a, b);
		int n = Math.min(a, b);
		long i =0;
		for (i = 1; i <= n; i++) {
			if (m * i % n == 0) {
				break;
			}
		}
		if(m*i > Long.MAX_VALUE)
		{
			throw new LimitExceededException();
		}
 		return m*i;
	}
	
	
	public long calculateAverage(int number) throws NegativeNoException, LimitExceededException {
		long sum = 0;
		if (number < 0) {
			throw new NegativeNoException(
					"Input for average LCM calculation cannot be negative.");
		}
		for (int i = 1; i <= number; i++) {
			sum = sum + calculate(number, i);
		}
		return sum / number;
	}
	
}
