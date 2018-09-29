package kr.ehd.javastudy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InspectSet {

	public static void main(String[] args) {
		Map<String, String> map = null;
		
		map = new HashMap<String, String>();
		
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		
		for(String key:map.keySet()) {
			System.out.println(String.format("%s : %s", key, map.get(key)));
		}
		
		List<String> list = new ArrayList<>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		
		System.out.println(list);
		System.out.println();

	}

}
