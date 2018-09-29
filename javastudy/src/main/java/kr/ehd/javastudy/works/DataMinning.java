package kr.ehd.javastudy.works;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DataMinning {
	final private String _filePath = "/apply_params_utf.txt";

	public static void main(String[] args) {
		DataMinning self = new DataMinning();
		
		self.doWorks();

	}
	
	void doWorks() {
		final List<String> list = readFile();
		final List<ElementVO> elementList = parseString(list);
		writeFile(elementList);
		
		
		
	}

	private void writeFile(List<ElementVO> elementList) {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:/temp/convert_file.csv"), "euc-kr"));
			
			bw.write("Element, Type, Id, Name, Value, Title\n");
			
			for (ElementVO e : elementList) {

				bw.write(String.format("%s, %s, %s, %s, %s, %s\n", e.getElement(), e.getType(), e.getId(), e.getName(), e.getValue(), e.getTitle()));
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null)try {bw.close();}catch(Exception e) {}
		}
		
	}

	private List<ElementVO> parseString(final List<String> list) {
		List<ElementVO> elementList = null;
		
		elementList = new ArrayList<>();
		
		for (String line : list) {
			
			if (line != null && line.length() > 0) {
				ElementVO vo = new ElementVO();
				line = line.replaceAll("\"", "");
				line = line.replaceAll("\'", "");
		
				
				String[] arr1 = line.split(" ");
				
				for (String s: arr1) {
					String[] strArr = null;
					if (s.startsWith("id")) {
						strArr = s.split("=");
						vo.setId(strArr.length > 1 ? strArr[1]:"");
					} else if (s.startsWith("name")) {
						strArr = s.split("=");
						vo.setName(strArr.length > 1 ? strArr[1]:"");
					} else if (s.startsWith("type")) {
						strArr = s.split("=");
						vo.setType(strArr.length > 1 ? strArr[1]:"");
					} else if (s.startsWith("value")) {
						strArr = s.split("=");
						vo.setValue(strArr.length > 1 ? strArr[1]:"");
					} else if (s.startsWith("title")) {
						strArr = s.split("=");
						vo.setTitle(strArr.length > 1 ? strArr[1]:"");
					} else if (s.startsWith("<input") ||s.startsWith("<select") ||s.startsWith("<form")) {
						vo.setElement(s.substring(1));
						
					}
					
				}
				System.out.println(vo);
				elementList.add(vo);
				
			}
			

		}
		
		
		System.out.println(elementList);
		
		return elementList;
	}

	private List<String> readFile() {
		List<String> list = null;
		String line = null;
		BufferedReader br = null;
		
		list = new ArrayList<>();
		
		try {
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(this._filePath)) );
			
			while((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();}catch(Exception e) {};
		}
		
		System.out.println(list);
		
		return list;
	}

}
