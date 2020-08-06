package CH14;

import java.util.Scanner;

class PasswordFormatException extends Exception{
	public PasswordFormatException (String message) {
		super(message);
	}
}
public class PasswordFormatTest {
	private String userPassword;
	public String getuserPassword(){
		return userPassword;
	}
	public void setuserPassword(String userPassword) throws PasswordFormatException{
		if(userPassword == null) {
			throw new PasswordFormatException("패스워드는 null일 수 없습니다.");			
		}
		else if(userPassword.matches("[a-zA-Z]+")) {
			throw new PasswordFormatException("패스워드는 영문자로만 만들 수 없습니다.");
		}
		else if(userPassword.matches("[0-9]+")) {
			throw new PasswordFormatException("패스워드는 숫자로만 만들 수 없습니다.");
		}
		else if(userPassword.length() <= 5) {
			throw new PasswordFormatException("패스워드는 6자 이상 적어주세요");
		}
		this.userPassword = userPassword;
		System.out.println("비밀번호가 적용되었습니다.");
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PasswordFormatTest test = new PasswordFormatTest();
		
		System.out.println("비밀번호를 입력하세요(문자열과 숫자조합 5자이상)");
		
		String userPassword = input.nextLine();
		try {
			test.setuserPassword(userPassword);
		} catch (PasswordFormatException e) {
			System.out.println(e.getMessage());
		}
		
//		userPassword = "abcdef";
//		try {
//			test.setuserPassword(userPassword);
//		} catch (PasswordFormatException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		userPassword = "123456";
//		try {
//			test.setuserPassword(userPassword);
//		} catch (PasswordFormatException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		userPassword = "abc45";
//		try {
//			test.setuserPassword(userPassword);
//		} catch (PasswordFormatException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		userPassword = "aa12345";
//		try {
//			test.setuserPassword(userPassword);
//		} catch (PasswordFormatException e) {
//			System.out.println(e.getMessage());
//		}

	}

}
