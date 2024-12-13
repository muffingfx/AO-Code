import java.util.*;;

public class BaseLibrary {
    //private record BaseEntry(double size, double speed, double dmg) {}
    //private record TypeEntry(double size, double speed, double dmg, double cooldown, double startup, double endlag, String animationId) {}
    public static Map<String, BaseEntry> baseMap = new HashMap<>();
    public static Map<String, TypeEntry> typeMap = new HashMap<>();
    public static void main(String[] args) {
        baseInit();
        typeInit();
    }

    public static void baseInit() {
        //baseMap.put("Ice", new BaseEntry(1.2, 0.85, 0.975));
    }

    public static void typeInit() {
        //typeMap.put("Blast", new TypeEntry(3, 144, 1, 0.75, 0.4, 0.5, "null"));
        
        typeMap.put("Flying Phoenix", new WeaponMoveEntry("Flying Phoenix", 11.7, 138, 1.177, 2, 0.4, 0.7, 1.3, 0.5, 1, "null"));
        typeMap.put("Flying Slash", new WeaponMoveEntry("Flying Slash", 11.7, 138, 0.817, 2, 0.4, 0.7, 1.3, 1, 1, "null"));
        typeMap.put("Piercing Gale", new WeaponMoveEntry("Piercing Gale", 11.5, 200, 0.845, 2, 0.55, 0.4, 1.1, 0.85, 1, "null"));
        typeMap.put("Primal Swipe", new WeaponMoveEntry("Primal Swipe", 7.9, 80, 1.088, 1.5, 0.3, 0.2, 1.1, 1, 1, "null"));
        typeMap.put("Striking Gale", new WeaponMoveEntry("Striking Gale", 15.9, 85, 0.986, 3, 0.45, 0.6, 2.2, 1, 1, "null"));
        typeMap.put("Sword Draw: Mountain Wind", new WeaponMoveEntry("Sword Draw: Mountain Wind", 10.4, 85, 1.466, 3, 0.45, 0.7, 1.05, 0.333, 1, "null"));

        typeMap.put("Shining Cycle", new WeaponMoveEntry("Shining Cycle", 14.5, 0, 0.604, 4, 0.35, 0.3, 3.45, 0.6, 1, "null"));
        typeMap.put("Whirlwind", new WeaponMoveEntry("Whirlwind", 17.95, 0, 0.729, 4, 0.45, 0.5, 4.35, 0.725, 0.7, "null"));
    }

    public static double getBaseSize(String name) {
        return baseMap.get(name).size();
    }

    public static double getBaseSpeed(String name) {
        return baseMap.get(name).speed();
    }

    public static double getBaseDamage(String name) {
        return baseMap.get(name).dmg();
    }

    public static double getTypeSize(String name) {
        return typeMap.get(name).size();
    }
    
    public static double getTypeSpeed(String name) {
        return typeMap.get(name).speed();
    }

    public static double getTypeDamage(String name) {
        return typeMap.get(name).dmg();
    }

    public static double getTypeStartup(String name) {
        return typeMap.get(name).startup();
    }

    public static double getTypeEndlag(String name) {
        return typeMap.get(name).endlag();
    }

    public static double getTypeCooldown(String name) {
        return typeMap.get(name).cooldown();
    }

    public static String getTypeAnimId(String name) {
        return typeMap.get(name).animationId();
    }
}

class WeaponLibrary {
    public static Map<String, Double> weaponTypeWeights = Map.ofEntries(
        Map.entry("Light Bladed", 0.15),
        Map.entry("Claws", 0.15),
        Map.entry("Axe", 0.25),
        Map.entry("Polearm", 0.25),
        Map.entry("Thrusting", 0.25),
        Map.entry("Bladed", 0.3),
        Map.entry("Dual Bladed", 0.3),
        Map.entry("Staff", 0.3),
        Map.entry("Katana", 0.35),
        Map.entry("Bludgeon", 0.4),
        Map.entry("Blunt", 0.4),
        Map.entry("Heavy Bladed", 0.4),
        Map.entry("Colossal Thrusting", 0.5),
        Map.entry("Heavy Blunt", 0.5),
        Map.entry("Heavy Cleaver", 0.5),
        Map.entry("Colossal Bladed", 0.6),
        Map.entry("Colossal Cleaver", 0.7),
        Map.entry("Shield", 1.0)
    );
    public static Map<String, Set<String>> weaponTypesMoves = Map.ofEntries(
        Map.entry("Flying Slash", Set.of("Light Bladed", "Bladed", "Katana", "Heavy Bladed", "Heavy Cleaver", "Colossal Cleaver", "Colossal Bladed")),
        Map.entry("Flying Phoenix", Set.of("Light Bladed", "Bladed", "Dual Bladed", "Katana", "Heavy Bladed", "Heavy Cleaver", "Colossal Cleaver", "Colossal Bladed")),
        Map.entry("Piercing Gale", Set.of("Polearm", "Staff")),
        Map.entry("Primal Swipe", Set.of("Claws")),
        Map.entry("Striking Gale", Set.of("Heavy Bladed", "Heavy Cleaver", "Colossal Cleaver")),
        Map.entry("Sword Draw: Mountain Wind", Set.of("Heavy Bladed", "Heavy Cleaver", "Colossal Cleaver")),
        Map.entry("Shining Cycle", Set.of("Light Bladed", "Bladed", "Dual Bladed", "Katana", "Heavy Bladed", "Thrusting", "Colossal Thrusting", "Colossal Bladed")),
        Map.entry("Whirlwind", Set.of("Light Bladed", "Axe", "Bladed", "Dual Bladed", "Katana", "Heavy Bladed", "Heavy Cleaver", "Colossal Cleaver", "Colossal Bladed"))
    );
;
    
}

class BaseEntry {
    private double size;
    private double speed;
    private double dmg;
    private String name;
    public BaseEntry(String name, double size, double speed, double dmg) {
        this.size = size;
        this.speed = speed;
        this.dmg = dmg;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double size() {
        return size;
    }

    public double speed() {
        return speed;
    }
    
    public double dmg() {
        return dmg;
    }

    public String name() {
        return name;
    }

    public String toString() {
        return name;
    }

}

class TypeEntry extends BaseEntry {
    private double cooldown;
    private double startup;
    private double endlag;
    private String animationId;
    private double sizePerTier;
    private double powerAffinity;
    private double sizeAffinityScaling;
    //private int levelReq;
    public TypeEntry(String name, double size, double speed, double dmg, double cooldown, double startup, double endlag, double sizePerTier, double powerAffinity, double sizeAffinityScaling, String animationId) {
        super(name, size, speed, dmg);
        this.cooldown = cooldown;
        this.startup = startup;
        this.endlag = endlag;
        this.animationId = animationId;
        this.sizePerTier = sizePerTier;
        this.powerAffinity = powerAffinity;
        this.sizeAffinityScaling = sizeAffinityScaling;
    }

    public double cooldown() {
        return cooldown;
    }

    public double startup() {
        return startup;
    }
    
    public double endlag() {
        return endlag;
    }

    public double sizePerTier() {
        return sizePerTier;
    }

    public String animationId() {
        return animationId;
    }

}

class WeaponMoveEntry extends TypeEntry {
    private Set<String> applicableWeapons = WeaponLibrary.weaponTypesMoves.get(super.getName());
    public WeaponMoveEntry(String name, double size, double speed, double dmg, double cooldown, double startup, double endlag, double sizePerTier, double powerAffinity, double sizeAffinityScaling, String animationId) {
        super(name, size, speed, dmg, cooldown, startup, endlag, sizePerTier, powerAffinity, sizeAffinityScaling, animationId);
    }

    public Set<String> getCompatibleWeapons() {
        return applicableWeapons;
    }
}

class MagicMoveEntry extends TypeEntry {
    
    public MagicMoveEntry(String name, double size, double speed, double dmg, double cooldown, double startup, double endlag, double sizePerTier, double powerAffinity, double sizeAffinityScaling, String animationId) {
        super(name, size, speed, dmg, cooldown, startup, endlag, sizePerTier, powerAffinity, sizeAffinityScaling, animationId);

    }
}

class Tool extends BaseEntry {
    private Set<TypeEntry> moveList = new HashSet<>();
    public Tool(String name, double size, double speed, double dmg, Set<TypeEntry> moveSet) {
        super(name, size, speed, dmg);
        this.moveList = moveSet;
    }

    public Set<TypeEntry> getMoveSet() {
        return moveList;
    }
}

class Magic extends Tool {
    public Magic(String name, double size, double speed, double dmg, Set<TypeEntry> moveList) {
        super(name, size, speed, dmg, moveList);
    }
}

class Weapon extends Tool {
    private String quality;
    private String weaponType;
    public Weapon(String name, double size, double speed, double dmg, Set<TypeEntry> moveSet, String quality, String weaponType) {
        super(name, size, speed, dmg, moveSet);
        this.quality = quality;
        this.weaponType = weaponType;
    }
}