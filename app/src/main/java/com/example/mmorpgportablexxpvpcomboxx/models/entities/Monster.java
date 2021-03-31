package com.example.mmorpgportablexxpvpcomboxx.models.entities;

import java.util.Random;

public class Monster extends Entity{

    private int xpDropped;
    private int goldDropped;

    public Monster() {
        super();
        getEntityLevel().setCurrentLevel(generateMonsterLevel(7, 1));

        setMaxHealth(getEntityLevel().getCurrentLevel() * 100);
        setCurrentHealth(getMaxHealth());

        xpDropped = generateXpDropped();
        goldDropped = generateXpDropped();
    }

    private static int generateMonsterLevel(int max, int min){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private int generateXpDropped(){
        Random r = new Random();
        return (getEntityLevel().getCurrentLevel()*  r.nextInt((2 - 1) + 1) + 1) * 3;
    }

    @Override
    public String toString() {
        return "LVL " + getEntityLevel().getCurrentLevel() + " Slime " + getCurrentHealth() + "/" + getMaxHealth();
    }

    public int getXpDropped() {
        return xpDropped;
    }

    public void setXpDropped(int xpDropped) {
        this.xpDropped = xpDropped;
    }

    public int getGoldDropped() {
        return goldDropped;
    }

    public void setGoldDropped(int goldDropped) {
        this.goldDropped = goldDropped;
    }
}
