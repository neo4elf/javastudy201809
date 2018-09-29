package kr.ehd.javastudy.ramda;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

public class InspectMethodReference {

	public static void main(String[] args) {
		InspectMethodReference self = new InspectMethodReference();
		
		self.test01();

	}

	private void test01() {
		
		// 일반적인 람다 형식
		System.out.println("sorted((i1, i2)-> i1.compareTo(i2)) : " +
			Arrays.asList(4, 3, 8, 1, 9, 6)
				  .stream()
				  .sorted((i1, i2)-> i1.compareTo(i2))
				  .collect(toList())
		);
		
		// 람다 함수 signature 와 유사한 동일 기능 함수 레퍼런스로 대체
		System.out.println("sorted(CompareUtil::compare) : " + 
				Arrays.asList(4, 3, 8, 1, 9, 6)
					  .stream()
					  .sorted(CompareUtil::compare)
					  .collect(toList())
		);

		// 람다 함수로 전달되는 2개의 파라미터중 첫번째 파라미터와 같은 Type 의 클래스 멤버 메소드를
		// 레퍼런스로 전달해서 첫번째파라미터가 전달된 메소드를 호출하는 것으로 대체
		System.out.println("sorted(Integer::compareTo) : " + 
				Arrays.asList(4, 3, 8, 1, 9, 6)
					  .stream()
					  .sorted(Integer::compareTo)
					  .collect(toList())
		);

		// 필터 집중
		// 필터에 전달되는 람다 함수의 파라미터를 전달된 인스턴스 변수의 메소드 인자로 입력하여 필터링 함
		Integer average = 8;
		System.out.println("filter(average::equals) : " + 
				Arrays.asList(4, 3, 8, 1, 9, 6)
					  .stream()
					  .filter(average::equals)
					  .sorted(Integer::compareTo)
					  .collect(toList())
		);
	}
	
	

}

class CompareUtil {
	public static int compare(Integer i1, Integer i2) {
		return i1.compareTo(i2);
	}
}
