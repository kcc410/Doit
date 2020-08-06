package CH14;
// 사용자 예외처리 클래스 생성 (Exception 상속)
class IDFormatException extends Exception{
	//예외생성시 메세지 입력하여 
	public IDFormatException(String message) {
		super(message);//메세지를 Exception에서 처리
	}
}
public class IDFormatTest {
	private String userID;
	//생성자는 생략:기본생성자
	public String getUserID() {//get메서드
		return userID;
	}//예외를 정의하는 메서드 만들기(사용자정의한예외 발생시 -> 호출하여 처리)
	public void setUserID(String userID) throws IDFormatException{
		if(userID == null) {
			throw new IDFormatException("아이디는 null일 수 없습니다.");			
		}
		//아이디 길이를 체크하여 8자리보다 작거나 20자리보다 클경우
		else if(userID.length() < 8 || userID.length() > 20) {
			throw new IDFormatException("아이디는 8자이상 20자이하로 쓰세요.");
		}
		this.userID = userID; //예외처리가 안될시 (합겹했을경우) 실행
	}
	public static void main(String[] args) {
		// 사용자 정의 예외처리
		IDFormatTest test = new IDFormatTest();
		String userID = null;
		try {
			test.setUserID(userID);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
		
		userID = "a1234567";
		try {
			test.setUserID(userID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
