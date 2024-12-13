public class Move<T extends MoveType> {
    private T moveType;
    private String baseType;
    private String customName;
    private double size;
    private int amount;
    public Move(T type, String base, String name, double size, int amount) {
        this.moveType = type;
        this.baseType = base;
        this.customName = name;
        this.size = size;
        this.amount = amount;
    }

    public T getMoveType() {
        return moveType;
    }

    public String toString() {
        if (!customName.equals("")) {
            return customName;
        }
        return baseType + " " + moveType.toString();
    }
}