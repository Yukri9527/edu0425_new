package edu0425.spring.demo;

public class Demo66 {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 10, 20, 30 } };
		int[][] ext_a = extend_sum(a);
		print_2D(ext_a);
//		System.out.println(fact(5));
//		System.out.println(gcb(888, 54));
		// fact(n)=1*2*3*....*n
	}

	private static int fact(int n) {
		if (n == 1) {
			return 1;
		} else {
			return fact(n - 1) * n;
		}
	}
			//斐波那契数列
	private static int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n - 2) + fib(n - 1);
		}
	}
			//辗转相除法
	private static int gcb(int a, int b) {
		//
		if (a % b == 0) {
			return b;
		} else {
			return gcb(b, a % b);
		}

	}
			//统计行列和
	private static int[][] extend_sum(int[][] a) {
		int rs[][] = new int[a.length + 1][a[0].length + 1];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				rs[i][j] = a[i][j];
				rs[i][a[i].length] += a[i][j];
				rs[a.length][j] += a[i][j];
				rs[a.length][a[i].length] += a[i][j];
			}
		}
		return rs;
	}

	private static void print_2D(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
