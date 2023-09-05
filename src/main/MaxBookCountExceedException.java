package main;

/**
 * 최대 책 용량을 초과해 책을 추가하려고 할 때 예외를 던집니다.
 * 
 * @author 이수정
 */
public class MaxBookCountExceedException extends RuntimeException {
    public MaxBookCountExceedException(String message) {
        super(message);
    }
}
