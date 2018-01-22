public class Magnet {

    private int cheat;

    public Magnet(int cheat) {
        this.cheat = cheat;
    }

    public int[] getCheat() {
        int[] result = {(cheat - 2), (cheat + 2)};
        return result;
    }
}