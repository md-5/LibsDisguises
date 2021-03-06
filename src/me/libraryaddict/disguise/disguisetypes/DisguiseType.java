package me.libraryaddict.disguise.disguisetypes;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.EntityType;

public enum DisguiseType {
    ARROW(EntityType.ARROW, 60),

    BAT(EntityType.BAT),

    BLAZE(EntityType.BLAZE),

    BOAT(EntityType.BOAT, 1),

    CAVE_SPIDER(EntityType.CAVE_SPIDER),

    CHICKEN(EntityType.CHICKEN),

    COW(EntityType.COW),

    CREEPER(EntityType.CREEPER),

    DONKEY(EntityType.HORSE),

    DROPPED_ITEM(EntityType.DROPPED_ITEM, 2, 1),

    EGG(EntityType.EGG, 62),

    ENDER_CRYSTAL(EntityType.ENDER_CRYSTAL, 51),

    ENDER_DRAGON(EntityType.ENDER_DRAGON),

    ENDER_PEARL(EntityType.ENDER_PEARL, 65),

    ENDER_SIGNAL(EntityType.ENDER_SIGNAL, 72),

    ENDERMAN(EntityType.ENDERMAN),

    EXPERIENCE_ORB(EntityType.EXPERIENCE_ORB),

    FALLING_BLOCK(EntityType.FALLING_BLOCK, 70, 1),

    FIREBALL(EntityType.FIREBALL, 63, 0),

    FIREWORK(EntityType.FIREWORK, 76),

    FISHING_HOOK(EntityType.FISHING_HOOK, 90),

    GHAST(EntityType.GHAST),

    GIANT(EntityType.GIANT),

    HORSE(EntityType.HORSE),

    IRON_GOLEM(EntityType.IRON_GOLEM),

    ITEM_FRAME(EntityType.ITEM_FRAME, 71),

    LEASH_HITCH(EntityType.LEASH_HITCH, 77),

    MAGMA_CUBE(EntityType.MAGMA_CUBE),

    MINECART(EntityType.MINECART, 10, 0),

    MINECART_CHEST(EntityType.MINECART_CHEST, 10, 1),

    MINECART_FURNACE(EntityType.MINECART_FURNACE, 10, 2),

    MINECART_HOPPER(EntityType.MINECART_HOPPER, 10),

    MINECART_MOB_SPAWNER(EntityType.MINECART_MOB_SPAWNER, 10, 4),

    MINECART_TNT(EntityType.MINECART_TNT, 10, 3),

    MULE(EntityType.HORSE),

    MUSHROOM_COW(EntityType.MUSHROOM_COW),

    OCELOT(EntityType.OCELOT),

    PAINTING(EntityType.PAINTING),

    PIG(EntityType.PIG),

    PIG_ZOMBIE(EntityType.PIG_ZOMBIE),

    PLAYER(EntityType.PLAYER),

    PRIMED_TNT(EntityType.PRIMED_TNT, 50),

    SHEEP(EntityType.SHEEP),

    SILVERFISH(EntityType.SILVERFISH),

    SKELETON(EntityType.SKELETON),

    SKELETON_HORSE(EntityType.HORSE),

    SLIME(EntityType.SLIME),

    SMALL_FIREBALL(EntityType.SMALL_FIREBALL, 64, 0),

    SNOWBALL(EntityType.SNOWBALL, 61),

    SNOWMAN(EntityType.SNOWMAN),

    SPIDER(EntityType.SPIDER),

    SPLASH_POTION(EntityType.SPLASH_POTION, 73),

    SQUID(EntityType.SQUID),

    THROWN_EXP_BOTTLE(EntityType.THROWN_EXP_BOTTLE, 75),

    UNDEAD_HORSE(EntityType.HORSE),

    VILLAGER(EntityType.VILLAGER),

    WITCH(EntityType.WITCH),

    WITHER(EntityType.WITHER),

    WITHER_SKELETON(EntityType.SKELETON),

    WITHER_SKULL(EntityType.WITHER_SKULL, 66),

    WOLF(EntityType.WOLF),

    ZOMBIE(EntityType.ZOMBIE),

    ZOMBIE_VILLAGER(EntityType.ZOMBIE);

    public static DisguiseType getType(org.bukkit.entity.EntityType entityType) {
        return DisguiseType.valueOf(entityType.name());
    }

    private int defaultData;
    private int defaultId;
    private int entityId;
    private EntityType entityType;
    private Class watcherClass;

    private DisguiseType(EntityType newType, int... obj) {
        entityType = newType;
        for (int i = 0; i < obj.length; i++) {
            int value = obj[i];
            switch (i) {
            case 0:
                entityId = value;
                break;
            case 1:
                defaultId = value;
                break;
            case 2:
                defaultData = value;
                break;
            default:
                break;
            }
        }
    }

    public int getDefaultData() {
        return defaultData;
    }

    public int getDefaultId() {
        return defaultId;
    }

    public int getEntityId() {
        return entityId;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public Class getWatcherClass() {
        return watcherClass;
    }

    public boolean isMisc() {
        return !entityType.isAlive();
    }

    public boolean isMob() {
        return entityType.isAlive() && entityType != EntityType.PLAYER;
    }

    public boolean isPlayer() {
        return entityType == EntityType.PLAYER;
    }

    public void setWatcherClass(Class c) {
        watcherClass = c;
    }

    public String toReadable() {
        String[] split = name().split("_");
        for (int i = 0; i < split.length; i++)
            split[i] = split[i].substring(0, 1) + split[i].substring(1).toLowerCase();
        return StringUtils.join(split, " ");
    }
}