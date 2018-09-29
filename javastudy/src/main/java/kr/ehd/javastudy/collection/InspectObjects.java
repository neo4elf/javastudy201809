package kr.ehd.javastudy.collection;

import java.util.Arrays;
import java.util.List;

public class InspectObjects {

	public static void main(String[] args) {
		int[] arr = {1, 9, 5, 6, 7};
		int[][] deepArr = {
				{1,2,3,4},
				{5,6,7,8}
		};
		
		System.out.println(Arrays.toString(arr));

		System.out.println(Arrays.deepToString(deepArr));
		
		int[] arr2 = Arrays.copyOf(arr, 8);
		
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = Arrays.copyOfRange(arr, 2, 8);
		
		System.out.println(Arrays.toString(arr3));
		
		Arrays.fill(arr3, 0);
		
		System.out.println(Arrays.toString(arr3));
		
		// Arrays.asList 로 생성된 List 객체는 읽기 전용이기때문에 add 메소드를 사용 할 수 없음
		List<Integer> list = Arrays.asList(new Integer[] {1,2,3,4,5});
		System.out.println(list);
		
		list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		
		// 배열 요소 검색
		// Arrays.binarySearch 꼭 배열이 정렬되어 있어야만 올바른 인덱스를 반환함
		System.out.println("arr2 : " + Arrays.toString(arr2));
		int idx = Arrays.binarySearch(arr2, 5);
		System.out.println(idx);
		
		Arrays.sort(arr2);
		System.out.println("arr2 : " + Arrays.toString(arr2));
		idx = Arrays.binarySearch(arr2, 5);
		System.out.println(idx);
		
	}

}
