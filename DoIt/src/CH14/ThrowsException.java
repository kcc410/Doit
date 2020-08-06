package CH14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {
	//이 메소드가 호출될때 예외를 처리한다.(파일이 없을경우 예외, 클래스를 못찾을 경우 예외)
	public Class loadClass(String fileName, String className) 
			throws FileNotFoundException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
		
	}
	public static void main(String[] args) {
		// 예외처리 : Throws
		ThrowsException test = new ThrowsException();
		// loadClass 메소드를 호출할 경우에 미뤘던 예외들을 처리해야한다.
		try {
			test.loadClass("a.txt", "java.lang.sString");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.out.println("파일을 못찾음 예외발생");			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("클래스를 못찾음 예외발생");
		}
	}
}
