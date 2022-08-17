import java.util.ArrayList;

public class BowlingGame {
    private final ArrayList<Frame> match;
    private static final int LAST_GAME = 9;

    public BowlingGame(ArrayList<Frame> match) {
        this.match = match;
    }

    public int score(ArrayList<Frame> match) {
        int finalScore = 0;
        for (int frame = 0; frame < match.size(); frame++) {
            if (match.get(frame).isStrike()) {
                finalScore += 10 + getStrikeBonus(frame);
            } else if (match.get(frame).isSpare()) {
                finalScore += 10 + getSpareBonus(frame);
            } else {
                finalScore += match.get(frame).getFirstRoll() + match.get(frame).getSecondRoll();
            }
        }
        return finalScore;
    }

    private int getStrikeBonus(int frameIndex) {
        // handle case when it's last game
        if (frameIndex == LAST_GAME) {
            return match.get(LAST_GAME).getSecondRoll() + match.get(LAST_GAME).getThirdRoll();
        }

        // handle case when next roll is also a strike
        if (match.get(frameIndex + 1).isStrike()) {
            if (frameIndex + 1 == LAST_GAME) { // handle case when next roll is strike AND is last game
                return match.get(LAST_GAME).getFirstRoll() + match.get(LAST_GAME).getSecondRoll();
            }
            return 10 + match.get(frameIndex + 2).getFirstRoll();
        }

        return match.get(frameIndex + 1).getFirstRoll() + match.get(frameIndex + 1).getSecondRoll();
    }

    private int getSpareBonus(int frameIndex) {
        if (frameIndex == LAST_GAME) {
            return match.get(LAST_GAME).getThirdRoll();
        }
        return match.get(frameIndex + 1).getFirstRoll();
    }
}
