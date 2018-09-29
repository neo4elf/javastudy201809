package kr.ehd.javastudy.practice.ecommerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import kr.ehd.javastudy.practice.ecommerce.vo.DiscountedProduct;
import kr.ehd.javastudy.practice.ecommerce.vo.Product;

public class Main {

	public static void main(String[] args) {
		Main self = new Main();
		
		List<Product> list = self.getProductList();
		List<Product> expensiveList = null;
		List<DiscountedProduct> discountedProductList = null;
		
		System.out.println(self.filter(list, p -> p.getPrice().compareTo(new BigDecimal("30")) > 0));
		
		expensiveList = self.filter(list, p->p.getPrice().compareTo(new BigDecimal("50")) > 0);
		
		discountedProductList = self.map(expensiveList, p->new DiscountedProduct(p.getId(), p.getName(), p.getPrice().divide(new BigDecimal("2"))));
		
		System.out.println(discountedProductList);
		
		Predicate<Product> filter = p -> p.getPrice().compareTo(new BigDecimal("30")) <= 0;

		System.out.println(self.filter(list, filter));
		
		// filter 에 정의 된 타입과, list 에 정의 된 타입이 서로 달라 오류 발생 함
		// discountProduct 가 product 를 상속 받았다 하더라도 filter 메소드의 argument 가 "T" 로 
		// 동일 하기 때문에 서로 다른 타입을 입력 할 수 없음. 이를 허용 하기 위해서 <? super T> 를 사용해야 함
		System.out.println(self.filter(discountedProductList, filter));
		
		BigDecimal discountTotal = self.sumFilter(discountedProductList, p -> p.getPrice());
		
		System.out.println("discountTotal : " + discountTotal);
	}
	
	/**
	 * <pre>
	 * description : It make sum all list member's price 
	 *
	 * </pre>
	 * @method sumFilter
	 * @param list
	 * @param fnc
	 * @return
	 */
	private<T> BigDecimal sumFilter(List<T> list, Function<T, BigDecimal> fnc) {
		BigDecimal total = BigDecimal.ZERO;
		
		for (T t : list) {
			total = total.add(fnc.apply(t));
		}
		
		return total;
	}

	/**
	 * <pre>
	 * description : list filter method
	 *
	 * </pre>
	 * @method filter
	 * @param list
	 * @param predicate
	 * @return
	 */
	private <T> List<T> filter(List<T> list, Predicate<? super T> predicate){
		List<T> result = new ArrayList<T>();
		for (T t : list) {
			if (predicate.test(t)) {
				result.add(t);
			}
		}
		
		return result;
	}
	
	/**
	 * <pre>
	 * description : List member type conversion method
	 *
	 * </pre>
	 * @method map
	 * @param list
	 * @param fnc
	 * @return
	 */
	private <T, R> List<R> map(List<T> list, Function<T, R> fnc) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(fnc.apply(t));
		}
		return result;
	}
	
	/**
	 * <pre>
	 * description : Generate list
	 *
	 * </pre>
	 * @method getProductList
	 * @return
	 */
	private List<Product> getProductList(){
		return Arrays.asList(
				new Product(1L, "A", new BigDecimal("10.00")),
				new Product(2L, "B", new BigDecimal("50.50")),
				new Product(3L, "C", new BigDecimal("110.99")),
				new Product(4L, "D", new BigDecimal("33.72")),
				new Product(5L, "E", new BigDecimal("85.20"))
				);
	}

}
