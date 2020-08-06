package CH14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling1 {
	public static void main(String[] args) {
		// 파일 입출력 예외처리
		FileInputStream fis = null; // 파일객체 fis 선언
		try { // 파일관련은 무조건 try안에 들어가야함
			fis = new FileInputStream("a.txt");// 파일객체 생성
		} catch (FileNotFoundException e) {
			// 파일을 찾지 못했을 경우
			// e.printStackTrace();
			System.out.println(e);// 에러 출력
			return;// 프로그램 메인문 종료
		} finally {
			// System.out.println("파이널리문");//리턴이 되었음에도 파이널리문은 실행됨.
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println(e);// 예외출력
				}
			}
			System.out.println("항상 출력됩니다.");
		}
		System.out.println("정상적으로 종료!");
	}
}
