package test;

import main.*;

/**
 * Dice, DiceCalculator 클래스를 테스트하기 위한 클래스입니다.
 * 
 * @author 이수정
 */
public class DiceMain {
    public static void main(String[] args) {
        Dice first = new Dice(6);
        Dice second = new Dice(2);

        System.out.println("주사위 합 = " + DiceCalculator.addDice(first, second));
        assert DiceCalculator.addDice(first, second) == 8;
        
        System.out.println("주사위 차 = " + DiceCalculator.subDice(first, second));
        assert DiceCalculator.subDice(first, second) == 4;
        
        System.out.println("주사위 곱 = " + DiceCalculator.mulDice(first, second));
        assert DiceCalculator.mulDice(first, second) == 12;
        
        System.out.println("주사위 몫 = " + DiceCalculator.divDice(first, second));
        assert DiceCalculator.divDice(first, second) == 3;
        
        
        Dice oddDice = new Dice(3);
        Dice evenDice = new Dice(4);
        
        System.out.println("oddDice는 홀수 주사위?? = " + DiceCalculator.isOdd(oddDice));
        assert DiceCalculator.isOdd(oddDice);
        
        System.out.println("evenDice는 홀수 주사위?? = " + DiceCalculator.isOdd(evenDice));
        assert !DiceCalculator.isOdd(evenDice);
        
        System.out.println("evenDice는 짝수 주사위?? = " + DiceCalculator.isEven(evenDice));
        assert DiceCalculator.isEven(evenDice);
        
        System.out.println("oddDice는 짝수 주사위?? = " + DiceCalculator.isEven(oddDice));
        assert !DiceCalculator.isEven(oddDice);
    }
}