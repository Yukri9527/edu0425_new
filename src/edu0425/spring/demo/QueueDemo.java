package edu0425.spring.demo;

public class QueueDemo {
	private int[] entries;

	private int length = 0;

	private int front = 0;

	public QueueDemo(int length) {
		entries = new int[length];

	}

	// ���
	public void enqueue(int item) {
		entries[length] = item;
		length++;
	}

	// ����
	public int dequeue() {
		int front_item = entries[front];
		for (int i = front + 1; i < length; i++) {
			entries[i - 1] = entries[i];
		}
		entries[--length] = 0;
		return front_item;
	}

	public int peek() {
		return 0;
	}

	public void print() {
		for (int i : entries) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
