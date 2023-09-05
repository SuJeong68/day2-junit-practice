package main;

/**
 * 주사위를 사용해 계산하는 클래스입니다.
 * 
 * @author 이수정
 */
public class DiceCalculator {
    private DiceCalculator() {
        throw new IllegalStateException("Utility class");
    }

    public static int addDice(Dice first, Dice second) {
        return first.getNumber() + second.getNumber();
    }

    public static int subDice(Dice first, Dice second) {
        return Math.abs(first.getNumber() - second.getNumber());
    }

    public static int mulDice(Dice first, Dice second) {
        return first.getNumber() * second.getNumber();
    }

    public static int divDice(Dice first, Dice second) {
        return first.getNumber() / second.getNumber();
    }

    public static boolean isOdd(Dice dice) {
        return dice.getNumber() % 2 != 0;
    }

    public static boolean isEven(Dice dice) {
        return dice.getNumber() % 2 == 0;
    }

}
