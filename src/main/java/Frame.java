public class Frame {
    private final int[] frame;

    public Frame(int[] frame) {
        this.frame = frame;
    }
    public int getFirstRoll() {
        return this.frame[0];
    }
    public int getSecondRoll() {
        return this.frame[1];
    }

    public int getThirdRoll() {
        return this.frame[2];
    }

    public boolean isStrike() {
        return this.getFirstRoll() == 10;
    }

    public boolean isSpare() {
        return this.getFirstRoll() + this.getSecondRoll() == 10;
    }
}
