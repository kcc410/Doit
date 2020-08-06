package CH14;

class AutoCloseObj implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// 인터페이스의 close()메소드 오버라이드
		System.out.println("리소스가 close() 되었습니다.");
	}
}

public class AutoCloseObjTest {
	public static void main(String[] args) {
		// AutoClose 사용하기
		try (AutoCloseObj obj = new AutoCloseObj()){			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//밑에꺼 선생님 사용 
		try {
			AutoCloseObj obj = new AutoCloseObj();
			obj.close();
			throw new Exception(); //강제 예외 발생
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
