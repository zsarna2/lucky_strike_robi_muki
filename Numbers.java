public class Numbers {

    final String color;
    final int number;
    final int column;
    final int iseven;
    final int dozen;
    final int half;
    final int[] doublecombinations;
    final int[] quadcombinations;

    public Numbers(String color, int number, int column, int iseven, int dozen,
                    int half, int[] doublecombinations, int[] quadcombinations) {
        this.color = color;
        this.number = number;
        this.column = column;
        this.iseven = iseven;
        this.dozen = dozen;
        this.half = half;
        this.doublecombinations = doublecombinations;
        this.quadcombinations = quadcombinations;
    }
}