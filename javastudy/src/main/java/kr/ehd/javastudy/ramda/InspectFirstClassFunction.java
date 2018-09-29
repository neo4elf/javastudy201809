package kr.ehd.javastudy.ramda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

public class InspectFirstClassFunction {

	public static void main(String[] args) {
		InspectFirstClassFunction self = new InspectFirstClassFunction();
		
		self.test01();
		self.test02();
		self.test03();
		self.test04();

	}

	private void test03() {
		// using return value
		System.out.println("Using asign variable");
		System.out.println("======================================");

		List<Function<Integer, String>> list = Arrays.asList(getDoubleStringMethodLamda(), getDoubleStringMethodFunction());
		
		for (Function<Integer, String> function : list) {
			System.out.println(function.apply(5));
		}
		
	}

	private void test02() {
		// using return value
		System.out.println("Using return value");
		System.out.println("======================================");
		
		Function<Integer, String> f1 = this.getDoubleStringMethodLamda();
		Function<Integer, String> f2 = this.getDoubleStringMethodFunction();
		
		System.out.println(f1.apply(4));
		System.out.println(f2.apply(4));
		
	}

	private void test01() {
		// using parameter
		System.out.println("Using parameter");
		System.out.println("======================================");
		print(3, i->String.valueOf(i*2));
		print(3, InspectFirstClassFunction::doubleStringMethod);
		
	}
	
	private Function<Integer, String> getDoubleStringMethodFunction(){
		return InspectFirstClassFunction::doubleStringMethod;
	}
	
	private Function<Integer, String> getDoubleStringMethodLamda(){
		return i->String.valueOf(i*2);
	}
	
	private static String doubleStringMethod(int i) {
		return String.valueOf(i * 2);
	}
	
	private void print(Integer i, Function<Integer, String> f) {
		System.out.println(f.apply(i));
	}
	
	private void test04() {
		Function<Integer, Section> f01 = i -> new Section(i);
		
		System.out.println("constructor with lambda : " + f01.apply(10));

		Function<Integer, Section> f02 = Section::new;
		
		System.out.println("constructor with new method : " + f02.apply(10));
		
		ProductA p01 = createProduct(1L, "A", new BigDecimal("10"), ProductA::new);
		ProductB p02 = createProduct(1L, "B", new BigDecimal("10"), ProductB::new);
		
		System.out.println("constructor with Factory :" + p01);
		System.out.println("constructor with Factory :" + p02);
	}
	
	private <T extends Product> T createProduct(Long id, String name, BigDecimal price, ProductConstructor<T> productConstructor) {
		return productConstructor.createObject(id, name, price);
	}

}

interface ProductConstructor<T extends Product> {
	public  T createObject(Long id, String name, BigDecimal price);
}

@AllArgsConstructor
@Data
class Section {
	private int number;
}

@AllArgsConstructor
@Data
abstract class Product{
	private Long id;
	private String name;
	private BigDecimal price;
}

class ProductA extends Product{
	public ProductA(Long id, String name, BigDecimal price) {
		super(id, name, price);
	}
	
	@Override
	public String toString() {
		return "A=" + super.toString();
	}
}

class ProductB extends Product{
	public ProductB(Long id, String name, BigDecimal price) {
		super(id, name, price);
	}
	
	@Override
	public String toString() {
		return "B=" + super.toString();
	}
}

