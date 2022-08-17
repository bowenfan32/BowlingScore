import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    ArrayList<Frame> match = new ArrayList<>();
    BowlingGame bowlingGame = new BowlingGame(match);

    @Test
    public void testNormalScore() {
        match.add(new Frame(new int[]{4, 3}));
        match.add(new Frame(new int[]{2, 1}));
        assertEquals(bowlingGame.score(match), 10);
    }

    @Test
    public void testAllOnesScore() {
        for (int i = 0; i < 10; i++) {
            match.add(new Frame(new int[]{1, 0}));
        }
        assertEquals(bowlingGame.score(match), 10);
    }

    @Test
    public void testSpareScore() {
        match.add(new Frame(new int[]{4, 6}));
        match.add(new Frame(new int[]{5, 0}));
        assertEquals(20, bowlingGame.score(match));
    }

    @Test
    public void testLastGameSpareScore() {
        for (int i = 0; i < 9; i++) {
            match.add(new Frame(new int[]{0, 0}));
        }
        match.add(new Frame(new int[]{5, 5, 0}));
        assertEquals(10, bowlingGame.score(match));
    }

    @Test
    public void testOneStrikeScore() {
        match.add(new Frame(new int[]{10, 0}));
        match.add(new Frame(new int[]{5, 4}));
        assertEquals(28, bowlingGame.score(match));
    }

    @Test
    public void testTwoStrikesScore() {
        match.add(new Frame(new int[]{10, 0}));
        match.add(new Frame(new int[]{10, 0}));
        match.add(new Frame(new int[]{1, 1}));
        assertEquals(35, bowlingGame.score(match));
    }

    @Test
    public void testLastGameStrikeScore() {
        for (int i = 0; i < 9; i++) {
            match.add(new Frame(new int[]{0, 0}));
        }
        match.add(new Frame(new int[]{10, 0, 0}));
        assertEquals(10, bowlingGame.score(match));
    }

    @Test
    public void testPerfectScore() {
        for (int i = 0; i < 9; i++) {
            match.add(new Frame(new int[]{10, 0}));
        }
        match.add(new Frame(new int[]{10, 10, 10}));
        assertEquals(300, bowlingGame.score(match));
    }
}
