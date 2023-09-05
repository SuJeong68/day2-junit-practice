package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.Dice;
import main.DiceCalculator;

/**
 * Dice, DiceCalculator 클래스를 Junit5를 이용해 테스트하는 클래스입니다.
 * 
 * @author 이수정
 */
@TestInstance(Lifecycle.PER_CLASS)
class DiceTest {
    private static final String OUT_OF_RANGE_MESSAGE = "1 미만 6 초과 주사위는 생성할 수 없습니다.";
    private Dice first;
    private Dice second;

    private static Stream<Arguments> provideAddParams() {
        return Stream.of(
            Arguments.of(1, 2, 3),
            Arguments.of(4, 6, 10),
            Arguments.of(3, 3, 6),
            Arguments.of(2, 5, 7),
            Arguments.of(6, 1, 7)
        );
    }

    @BeforeEach
    void setUp() {
        first = new Dice(6);
        second = new Dice(2);
    }

    @ParameterizedTest
    @MethodSource("provideAddParams")
    @DisplayName("addDice 성공")
    void addDice() {
        assertEquals(DiceCalculator.addDice(first, second), 8);
    }

    @Test
    @DisplayName("subDice 성공")
    void subDice() {
        assertEquals(DiceCalculator.subDice(first, second), 4);
    }

    @Test
    @DisplayName("mulDice 성공")
    void mulDice() {
        assertEquals(DiceCalculator.mulDice(first, second), 12);
    }

    @Test
    @DisplayName("divDice 성공")
    void divDice() {
        assertEquals(DiceCalculator.divDice(first, second), 3);
    }

    @Test
    @DisplayName("음수 값의 주사위를 생성할 수 없을 때, IllegalArgumentException을 던짐.")
    void negativeDice_throwIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dice(-1));
        assertEquals(exception.getMessage(), OUT_OF_RANGE_MESSAGE);
    }

    @AfterAll
    void done() {
        System.out.println("DiceTest done.");
    }
}
