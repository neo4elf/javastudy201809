package kr.ehd.javastudy.practice.ecommerce.vo;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=false)
public class DiscountedProduct extends Product {

	public DiscountedProduct(long id, String name, BigDecimal price) {
		super(id, name, price);
	}
}
