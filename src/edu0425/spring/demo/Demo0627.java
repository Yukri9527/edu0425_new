package edu0425.spring.demo;

import java.util.Stack;

public class Demo0627 {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		int[] b = { 1, 2, 4, 2, 6, 2 };
		int[] c = { 1, 2, 4, 9, 11, 15 };
		String edu = "13+52-*6/";
//		System.out.println(calcT(1, 5));
//		System.out.println(calcT(2, 5));
//		System.out.println(calcT(3, 5));
//		System.out.println(edu + "的结果是" + rpn(edu));
		// findSumTarget(c, 10);
		// moveArray(a, 4);
		// findNums(b);
//		QueueDemo qd =new QueueDemo(10);
//		qd.enqueue(3);
//		qd.enqueue(4);
//		qd.enqueue(5);
//		qd.enqueue(6);
//		System.out.println("出队"+qd.dequeue());
//		qd.print();
		// 5,10,15,11,12,3,8
		NodeDemo node =new NodeDemo(5);
		node.insert(5);
		node.insert(10);
		node.insert(15);
		node.insert(11);
		node.insert(12);
		node.insert(3);
		node.insert(8);
		//中序遍历
		node.inorder();
		
	}
	// 数组移位 [1,2,3,4] -> [4,1,2,3] (移动一位)

	private static void moveArray(int[] a, int k) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if ((i + k) <= (a.length - 1)) {
				b[i + k] = a[i];

			} else {
				b[i + k - a.length] = a[i];
			}
		}
		for (int j = 0; j < a.length; j++) {
			System.out.println(b[j]);
		}

	}

	// 找到 1，a[i]< n(n为数组大小) 找到1~n中未出现在此数组中的数字
	// 要求O(n) 不能使用辅助数组
	// [1,3,3,4,4] sout :2,5;
	private static void findNums(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i]) - 1] >= 0) {

				nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];// 将对应下标的位变负
			} // 下标即为辅助数组
		}
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] > 0) {
				System.out.print(j + 1 + " ");
			}
		}

	}

	// 数组内有两个数 和为target 找到这两个数的下标
	private static void findSumTarget(int[] a, int target) {
		int[] result = new int[2];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] + a[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		System.out.println(result[0] + "," + result[1]);
	}

	private static final char PLUS = '+';
	private static final char REDU = '-';
	private static final char MUTI = '*';
	private static final char DIV = '/';

	private static int rpn(String equ) {
		int result = 0;
		char[] charArray = equ.toCharArray();
		Stack<Integer> s = new Stack<Integer>();
		// 入栈 push 出站pop
		for (int i = 0; i < charArray.length; i++) {
			if (isNum(charArray[i])) {
				int num = Character.getNumericValue(charArray[i]);
				s.push(num);
//				System.out.println(num);
			} else {
				int after = s.pop();
				int later = s.pop();
				switch (charArray[i]) {
				case PLUS:
					result = later + after;
					s.push(result);
					break;
				case REDU:
					result = later - after;
					s.push(result);
					break;
				case MUTI:
					result = later * after;
					s.push(result);
					break;
				case DIV:
					result = later / after;
					s.push(result);
					break;

				}
			}
		}
		return (int) s.pop();
	}

	private static boolean isNum(char c) {
		if (c < 48 || c > 57) {
			return false;
		} else {
			return true;
		}
	}

	private static final int[] C = { 1, 2, 4, 7 }; // 硬币种类

	// 零钱找零 n为可以使用的硬币 m为金额总数
	private static int calcT(int n, int m) {

		if (n < 0 || m <= 0) {
			return 0;
		}
		int count = 0;
		if (m >= C[n]) { // m=5, n=1,	C[n]=2;(2,2,1)=3 	递归得到可以使用的最大面额的硬币
			count = m / C[n];
			if (m % C[n] != 0) {
				count += calcT(n - 1, m % C[n]); // 	用了count张大面额后 剩余钱减少面额 重新递归
			}
		} else
			return calcT(n - 1, m); // 减少使用的最大硬币面额
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
