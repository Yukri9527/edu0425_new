package edu0425.spring.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFileDemo {
	private static String email_filepath = "E:\\Java_work\\eclipse_workspace\\edu0425_new\\src\\u-email.txt";
	private static String phone_filepath = "E:\\Java_work\\eclipse_workspace\\edu0425_new\\src\\u-phone.txt";
	private static String out_filepath = "E:\\Java_work\\eclipse_workspace\\edu0425_new\\src\\u-out.txt";
	private static String out_filepath1 = "E:\\Java_work\\eclipse_workspace\\edu0425_new\\src\\u-out1.txt";

	public static void main(String[] args) {
		try {
//			readFile1(email_filepath);
//			readFile2(phone_filepath);
//			writeFile(out_filepath);
			mergeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readFile1(String filepath) throws IOException {

		FileInputStream fin = new FileInputStream(filepath);
		InputStreamReader reader = new InputStreamReader(fin, "UTF-8");
		BufferedReader buffer = new BufferedReader(reader);
		buffer.readLine(); // 空读一行
		String strTmp = "";
		while ((strTmp = buffer.readLine()) != null) {
			String[] str = strTmp.split("\\s");
			System.out.println(str[0] + "," + str[1] + "," + str[2]);
		}
		buffer.close();
		reader.close();
		fin.close();
	}

	// 新版本jdk文件流读取方法
	private static void readFile2(String filepath) throws IOException {
		Path path = Paths.get(filepath);
		List<String> lines = Files.readAllLines(path);
		for (String line : lines) {
			System.out.println(line);
		}
	}

	private static void writeFile(String filepath) throws IOException {
		File writeName = new File(filepath);
		// 创建新文件 有同名会直接覆盖掉
		writeName.createNewFile();

		FileWriter writer = new FileWriter(writeName);
		BufferedWriter out = new BufferedWriter(writer);
		out.write("hello world \r\n");// \r,\n为回车换行
		out.write("会当凌绝顶，一览众山小");
		out.flush();// 将缓存区内容压入到文件
		out.close();

	}

	private static void mergeFile() throws IOException {
		
		//WriteFile
		File writeName = new File(out_filepath1);
		writeName.createNewFile();
		FileWriter writer = new FileWriter(writeName);
		BufferedWriter out = new BufferedWriter(writer);
		//ReadFile
		List<String> f1_id = new ArrayList<String>();
		List<String> f1_name = new ArrayList<String>();
		List<String> f1_email = new ArrayList<String>();

		List<String> f2_id = new ArrayList<String>();
		List<String> f2_name = new ArrayList<String>();
		List<String> f2_phone = new ArrayList<String>();

		FileInputStream fin = new FileInputStream(email_filepath);
		InputStreamReader reader = new InputStreamReader(fin, "UTF-8");
		BufferedReader buffer = new BufferedReader(reader);

		String strTmp = "";
		buffer.readLine();
		while ((strTmp = buffer.readLine()) != null) {
			String[] str = strTmp.split("\\s");
			f1_id.add(str[0]);
			f1_name.add(str[1]);
			f1_email.add(str[2]);
		}
		fin = new FileInputStream(phone_filepath);
		reader = new InputStreamReader(fin, "UTF-8");
		buffer = new BufferedReader(reader);
		strTmp = "";
		buffer.readLine();

		while ((strTmp = buffer.readLine()) != null) {
			String[] str = strTmp.split("\\s");
			f2_id.add(str[0]);
			f2_name.add(str[1]);
			f2_phone.add(str[2]);

		}
		buffer.close();
		reader.close();
		fin.close();
		// merge
		for (int i = 0; i < f1_id.size(); i++) {
			if (f2_id.contains(f1_id.get(i))) {
				System.out.println(
						f1_id.get(i) + "\t" + f1_name.get(i) + "\t" + f1_email.get(i) + "\t" + f2_phone.get(i));
				out.write(f1_id.get(i) + "\t" + f1_name.get(i) + "\t" + f1_email.get(i) + "\t" + f2_phone.get(i));
				out.write("\r\n");
			} else {
				System.out
						.println(f1_id.get(i) + "\t" + f1_name.get(i) + "\t" + f1_email.get(i) + "\t" + "------------");
				out.write(f1_id.get(i) + "\t" + f1_name.get(i) + "\t" + f1_email.get(i) + "\t" + "------------");
				out.write("\r\n");
			}
		}

		for (int j = 0; j < f2_id.size(); j++) {
			if (!f1_id.contains(f2_id.get(j))) {
				System.out
						.println(f2_id.get(j) + "\t  " + f2_name.get(j) + "   -----------" + "\t\t" + f2_phone.get(j));
				out.write(f2_id.get(j) + "\t  " + f2_name.get(j) + "   -----------" + "\t\t" + f2_phone.get(j));
				out.write("\r\n");
			}
		}
		out.flush();// 将缓存区内容压入到文件
		out.close();
	}
}
