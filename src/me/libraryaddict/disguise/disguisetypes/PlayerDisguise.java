package me.libraryaddict.disguise.disguisetypes;

public class PlayerDisguise extends Disguise {
    private String playerName;

    public PlayerDisguise(String name) {
        this(name, true);
    }

    public PlayerDisguise(String name, boolean replaceSounds) {
        if (name.length() > 16)
            name = name.substring(0, 16);
        playerName = name;
        createDisguise(DisguiseType.PLAYER, replaceSounds);
    }

    @Override
    public PlayerDisguise clone() {
        PlayerDisguise disguise = new PlayerDisguise(getName(), replaceSounds());
        disguise.setViewSelfDisguise(viewSelfDisguise());
        disguise.setHearSelfDisguise(canHearSelfDisguise());
        disguise.setHideArmorFromSelf(isHidingArmorFromSelf());
        disguise.setHideHeldItemFromSelf(isHidingHeldItemFromSelf());
        disguise.setVelocitySent(isVelocitySent());
        disguise.setWatcher(getWatcher().clone(disguise));
        return disguise;
    }

    public String getName() {
        return playerName;
    }

}