package main;

/**
 * 주사위 클래스입니다.
 * 
 * @author 이수정
 */
public class Dice {
    private int number;

    public Dice(int number) {
        if (number < 1 || number > 6)
            throw new IllegalArgumentException("1 미만 6 초과 주사위는 생성할 수 없습니다.");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
