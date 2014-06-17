package com.calculator.lcm;
public class FirstProgram {
	
	public static void main(String[] args) {
		System.out.println("A(n)=" + avg_lcm(Integer.parseInt(args[0])));
	}

	public static int lcm(int a, int b) {
		int m, n, i;
		if (a > b) {
			m = a;
			n = b;
		}

		else {
			m = b;
			n = a;
		}
		for (i = 1; i <= n; i++) {
			if (m * i % n== 0) {
				break;
			}
		}

		return m * i;
	}

	public static int avg_lcm(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += lcm(n, i);
		}
		return sum / n;
	}

}
