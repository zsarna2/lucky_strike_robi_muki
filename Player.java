public class Player {

    private String name;
    private int cash;

    public Player(String name, int cash) {
        this.name = name;
        this.cash = cash;
    }

    public String getName(){
        return name;
    }

    public int getCash(){
        return cash;
    }
}