package kr.ehd.javastudy.jsoup;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import kr.ehd.javastudy.works.ElementVO;

public class KCUApplyGettering {
	
//	private final String[] _html_file_path = {
//			"C:/Temp/kcu_apply_form_20180928/신입학_교육기회균등전형.html",
//			"C:/Temp/kcu_apply_form_20180928/신입학_군위탁전형.html",
//			"C:/Temp/kcu_apply_form_20180928/신입학_산업체전형.html",
//			"C:/Temp/kcu_apply_form_20180928/신입학_일반전형.html",
//			"C:/Temp/kcu_apply_form_20180928/신입학_중앙부처공무원위탁전형.html"			
//	};

	private final String[] _html_file_path = {
			"/html/신입학_교육기회균등전형.html",
			"/html/신입학_군위탁전형.html",
			"/html/신입학_산업체전형.html",
			"/html/신입학_일반전형.html",
			"/html/신입학_중앙부처공무원위탁전형.html"	
	};

	public static void main(String[] args) {
		KCUApplyGettering self = new KCUApplyGettering();
		
		self.doWorks();

	}

	private void doWorks() {
		List<ElementVO> list = null;
		List<List<ElementVO>> allList = new ArrayList<>();
		
		InputStream is = null;
		
		for (String string : _html_file_path) {
//			File file = new File(string);
//			
//			list = parseHtml(file);
//			allList.add(list);
			
			try {
				is = getClass().getResourceAsStream(string);
				
				list = parseHtml(is);
				
				allList.add(list);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(is != null)try {is.close();}catch(Exception e) {}
			}
			
		}
		
		analizeList(allList);
	}
	
	public List<ElementVO> parseHtml(InputStream is) {
		Document doc = null;
		List<ElementVO> list = null;
		
		try {
			doc = Jsoup.parse(is, "UTF-8", "http://go.kcu.ac");
			
			Elements inputs = doc.select("input");	// css 스타일의 select -- jquery selector style
			Elements selects = doc.select("select");
			
			list = new ArrayList<>();
			
			list.addAll(this.getElementVOList(inputs));
			list.addAll(this.getElementVOList(selects));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println("final : " + list);
		
		return list;
	}

	public List<ElementVO> parseHtml(File parsedFile) {
		Document doc = null;
		List<ElementVO> list = null;
		
		try {
			doc = Jsoup.parse(parsedFile, "UTF-8");
			
			Elements inputs = doc.select("input");	// css 스타일의 select -- jquery selector style
			Elements selects = doc.select("select");
			
			list = new ArrayList<>();
			
			list.addAll(this.getElementVOList(inputs));
			list.addAll(this.getElementVOList(selects));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println("final : " + list);
		
		return list;
	}

	private void analizeList(List<List<ElementVO>> allList) {
		final int[] idx = {0};
		
		List<ElementVO> list0 = allList.get(0);
		List<ElementVO> list1 = allList.get(1);
		
		allList.stream()
				.forEach(l -> System.out.println(++idx[0] + " : " + l.size()));
		
		System.out.println("================================================");

		Long start = System.currentTimeMillis();
		System.out.print(" Using for loop : ") ;
		for (ElementVO vo1 : list0) {
			boolean bool = false;
			
			for (ElementVO vo2 : list1) {
				if(vo1.equals(vo2)) {
					bool = true;
					break;
				}
			}
			
			if (!bool) {
				System.out.println(vo1);
			}
		}
		System.out.println("estimated : " + (System.currentTimeMillis() - start));
		
		System.out.println("================================================");
		
		Long start1 = System.currentTimeMillis();
		System.out.println(" Using stream : " + 
		list0.stream()
		     .filter(
		    		 // anyMatch 는 전체중 하나라도, allMathch 는 모두 의 의미
//		     	vo1-> !list1.stream().anyMatch(vo2 -> vo2.equals(vo1))
		     	vo1-> !list1.stream().anyMatch(vo1::equals)
		     )
		     .collect(toList())
		);
		System.out.println("estimated : " + (System.currentTimeMillis() - start1));
	}
	
	private List<ElementVO> getElementVOList(Elements elm){
		List<ElementVO> list = new ArrayList<ElementVO>();
		
		Long start = System.currentTimeMillis();
		
//		for (Element element : elm) {
//			ElementVO vo = new ElementVO();
//			vo.setElement(element.nodeName());
//			vo.setId(element.id());
//			vo.setName(element.attr("name"));
//			vo.setTitle(element.attr("title"));
//			vo.setType(element.attr("type"));
//			vo.setValue(element.attr("value"));
//			
//			list.add(vo);
//		}
		
		elm.stream()
		   .forEach(e->{
			   ElementVO vo = new ElementVO();
				vo.setElement(e.nodeName());
				vo.setId(e.id());
				vo.setName(e.attr("name"));
				vo.setTitle(e.attr("title"));
				vo.setType(e.attr("type"));
				vo.setValue(e.attr("value"));
				
				list.add(vo);
		   });
		System.out.println("estimated : " + (System.currentTimeMillis() - start));
//		System.out.println(list);
		
		return list;
	}

}
