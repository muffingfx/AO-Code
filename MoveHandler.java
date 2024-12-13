import java.util.*;

public class MoveHandler {
    public static void main(String[] args) {
       Move<Projectile> iceBlast = new Move<>(new Projectile("Blast"), "Ice", "", 1, 1);
       System.out.println(iceBlast);
    }

    public static double damageCalc(Move<? extends MoveType> move, int level, int power) {
        
    }

   // public static Move<? extends MoveType> create(String type, String base, String name, double size, int amount) {
        
   // }
}
