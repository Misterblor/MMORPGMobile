package com.example.mmorpgportablexxpvpcomboxx;

public class Entity {

    private int maxHealth;
    private int currentHealth;

    private int maxMana;
    private int currentMana;


    private int currentLevel;
    private int currentXp;
    private int xpNeededToNextLevel;

    public Entity() {
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public void setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
    }

    public int getXpNeededToNextLevel() {
        return xpNeededToNextLevel;
    }

    public void setXpNeededToNextLevel(int xpNeededToNextLevel) {
        this.xpNeededToNextLevel = xpNeededToNextLevel;
    }

    public String levelToString(){
        return "LVL " + currentLevel + "(" + currentXp + "/" + xpNeededToNextLevel + ")";
    }

    public int getPercentageHealth(){
        return (int) (((float)currentHealth / (float)maxHealth) * 100);
    }
}
