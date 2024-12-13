public class Projectile extends MoveType {
    private String type;
    public Projectile(String type) {
        super("Projectile");
        this.type = type;
        
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
