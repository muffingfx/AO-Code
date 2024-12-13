public abstract class MoveType {
    private String type;
    private double baseDmg;
    private double baseSize;
    private double baseSpeed;
    private double startup;
    private double endlag;
    private double cooldown;
    private String animationId;
    public MoveType(String t) {
        type = t;
    }

    abstract String getType();

    public String getGenericType() {
        return type;
    }

    public String toString() {
        return type;
    }
}
