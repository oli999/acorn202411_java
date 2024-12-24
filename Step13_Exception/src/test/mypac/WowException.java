package test.mypac;

public class WowException extends RuntimeException{// RuntimeException 클래스를 상속 받아서 만든다
	//생성자의 매개 변수로 예외 메세지를 전달받아서 
	public WowException(String msg) {
		//부모 생성자에 전달해 준다.
		super(msg);
	}
}
