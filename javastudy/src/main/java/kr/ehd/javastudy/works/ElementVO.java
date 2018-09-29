package kr.ehd.javastudy.works;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// @AllArgsConstructor
@Getter
@Setter
@ToString
public class ElementVO {
	private String element;
	private String name;
	private String id;
	private String value;
	private String type;
	private String title;
	
	public boolean equals(ElementVO vo) {
		return this.name != null && this.name.equals(vo.getName());
	}
}
