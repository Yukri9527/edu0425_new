package edu0425.spring.demo;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// Date 类
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance();
		System.out.println(df.format(date));

		// Calendar 类
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);

		int year = c.get(Calendar.YEAR);
		System.out.println(year);

		int month = c.get(Calendar.MONTH);
		System.out.println(month);

		System.out.println("2019:" + getDaysofFeb(2019));
		System.out.println("2020:" + getDaysofFeb(2020));

		System.out.println("SAT:" + c.get(Calendar.DAY_OF_WEEK));
		c.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println("SUN:" + c.get(Calendar.DAY_OF_WEEK));
		System.out.println(getFinishDate(300));
		// SUN:1 SAT:7
		// (c.MONTH ==4 ||c.month==9)&&c.DAY_OF_MONTH==1
		// c.DAY_OF-WEEK==1||C.DAY_OF_WEEK==7
		// c.,add(Calendar.DAY_OF_YEAR,1)
	}

	private static int getDaysofFeb(int year) {
		Calendar c = Calendar.getInstance();
		// 月份是从0开始的 设置成3月1号
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	private static String getFinishDate(int days) {
		Calendar c = Calendar.getInstance();
		int i = 0;
		while (i < days) {
			c.add(Calendar.DAY_OF_YEAR, 1);

			if (c.get(Calendar.DAY_OF_WEEK) == 1) {
				continue;
			} else if (c.get(Calendar.DAY_OF_WEEK) == 7) {
				continue;
			} else if (c.get(Calendar.DAY_OF_MONTH) == 1) {
				if (c.get(Calendar.MONTH) == 4 || c.get(Calendar.MONTH) == 9) {
					continue;
				} else {
					i++;
				}
			}
			else {
				i++;
			}
		}
		Date date = c.getTime();
		return date.toString();
	}
}
