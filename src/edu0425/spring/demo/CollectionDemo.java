package edu0425.spring.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import edu0425.spring.vo.DeptInfo;

public class CollectionDemo {

	public static void main(String[] args) {

		DeptInfo d1 = new DeptInfo(1, "dept1", "loc1");
		DeptInfo d2 = new DeptInfo(1, "dept2", "loc2");
		DeptInfo d3 = new DeptInfo(1, "dept3", "loc3");

		List<DeptInfo> list1 = new ArrayList<DeptInfo>();
		// List<DeptInfo> list1 = new LinkedList<DeptInfo>();
		list1.add(d1);
		list1.add(d2);
		list1.add(d3);

		// ���ֲ�ͬ�� �������Ϸ�ʽ
//		printDeptList(list1);
//		Map������ ����ͳ
		Map<Integer, DeptInfo> map1 = new HashMap<Integer, DeptInfo>();
		map1.put(1, d1);
		map1.put(2, d2);
		map1.put(3, d3);

//		System.out.println("Deptno=2:" + map1.get(2));

		// Guava ��ܣ����ͼ�����
		List<DeptInfo> guava_list = Lists.newArrayList(d1, d2, d3);
//		printDeptList(guava_list);
//		List<DeptInfo> guava_list = Lists.newLinkedList();
		Map<Integer, DeptInfo> guava_map = Maps.newHashMap();
		guava_map.put(1, d1); // ��Ӧ�Ķ���Ҳ������һ��list
		guava_map.put(2, d2);
		guava_map.put(3, d3);

//		System.out.println("Deptno=3 :" + guava_map.get(3));

		// �ɷ�ʽ
		Map<String, List<DeptInfo>> map_list1 = new HashMap<String, List<DeptInfo>>();
		map_list1.put("guava_list", guava_list);
		map_list1.put("list1", list1);
//		printDeptList(map_list1.get("list1"));
//		printDeptList(map_list1.get("guava_list"));

		// �·�ʽ
		Multimap<String, DeptInfo> map_list2 = ArrayListMultimap.create();
		map_list2.put("list1", d1);
		map_list2.put("list1", d2);
		map_list2.put("list1", d3);

		map_list2.put("guava_list", d2);
		map_list2.put("guava_list", d3);

		// ͬ��list1��ע����ֵ d1 d2 d3 ArrayListMultimap�Զ���list1 �Ŀռ��Ϊ ArrayList �����Ǹ��ǵ�
//		System.out.println(map_list2.get("list1"));
//		System.out.println(map_list2.get("guava_list"));

		// ��������ת��Ϊ�ض��滮���ַ���
		// ��list2�ڵ��ַ���ƴ����һ��
		List<String> list2 = Lists.newArrayList("aa","bb","cc");
		String str1 = "";
		for(int i=0;i<list2.size();i++) {
			str1=str1+":"+list2.get(i);
		}
		System.out.println(str1);
		//	��ǿfor ѭ��
		String str2 = "";
		for(String s:list2) {
			str2=str2+":"+s;
		}
		System.out.println(str2);
		
		//guava listƴ�ӹ�����
		String str3=Joiner.on(":").join(list2);
		System.out.println(str3);
		
		List<String> list3 = Lists.newArrayList();
		String[] s_p=str3.split(":");
		for(String s:s_p) {
			System.out.println(s);
		}
		for(String s:s_p) {
			list3.add(s);
		}
		System.out.println(list3);
		//�ַ�����ֹ�����
		List<String> list4 = Splitter.on(":").splitToList(str3);
		System.out.println(list4);
	}

	private static void printDeptList(List<DeptInfo> list1) {
		System.out.println("print start");
		for (DeptInfo dept : list1) {
			System.out.println(dept);
		}

		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}
}
