package com.example.mmorpgportablexxpvpcomboxx.models.entities;

public class Entity {

    private int maxHealth;
    private int currentHealth;

    private int maxMana;
    private int currentMana;


    private Level entityLevel;

    public Entity() {
        entityLevel = new Level(1, 0, 20);
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

    public Level getEntityLevel() {
        return entityLevel;
    }

    public void setEntityLevel(Level entityLevel) {
        this.entityLevel = entityLevel;
    }

    public String levelToString(){
        return "LVL " + entityLevel.getCurrentLevel() + "(" + entityLevel.getCurrentXp() + "/" + entityLevel.getXpNeededToNextLevel() + ")";
    }

    public int getPercentageHealth(){
        return (int) (((float)currentHealth / (float)maxHealth) * 100);
    }

    public int getPercentageMana(){
        return (int) (((float)currentMana / (float)maxMana) * 100);
    }
}
