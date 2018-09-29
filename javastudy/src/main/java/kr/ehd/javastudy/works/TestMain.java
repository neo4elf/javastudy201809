package kr.ehd.javastudy.works;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class TestMain {

	public static void main(String[] args) {
		TestMain self = new TestMain();
		
		self.doWorks();
		

	}

	private void doWorks() {
		char[] cbuf = new char[1024];
		Reader reader = new InputStreamReader(getClass().getResourceAsStream("/test.txt") );

		try {
			reader.read(cbuf);
			
			System.out.println(cbuf);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(reader != null)try {reader.close();}catch(Exception e) {}
		}
	}

}
