package com.example.mmorpgportablexxpvpcomboxx;

public class Player extends Entity {

    private int atk;
    private int def;

    private int str;
    private int intelligence;

    private int distribPoints;

    private int currentGold;

    private String name;

    public Player(String name) {
        str = 10;
        intelligence = 10;
        atk = (int) (str * 1.5);
        def = str * 2;

        currentGold = 0;
        distribPoints = 0;

        setMaxHealth(100);
        setCurrentHealth(getMaxHealth());

        setMaxMana(100);
        setCurrentMana(getMaxMana());

        setCurrentLevel(1);
        setCurrentXp(0);
        setXpNeededToNextLevel(20);

        this.name = name;
    }

    private int computeXpNeededToNextLevel(){
        return (int)(getXpNeededToNextLevel() * 1.2);
    }

    public void recieveXp(int xp){
        int actualXp = xp;
        while (actualXp > 0){
            if (getCurrentXp() + actualXp < getXpNeededToNextLevel()){
                setCurrentXp(getCurrentXp() + actualXp);
                break;
            } else if (getCurrentXp() + actualXp == getXpNeededToNextLevel()){
                setCurrentXp(0);
                setCurrentLevel(getCurrentLevel() + 1);
                distribPoints += 2;
                setXpNeededToNextLevel(computeXpNeededToNextLevel());
                setCurrentMana(getMaxMana() + 5);
                break;
            } else {
                actualXp -= getXpNeededToNextLevel() - getCurrentXp();
                setCurrentXp(0);
                setCurrentLevel(getCurrentLevel() + 1);
                distribPoints += 2;
                setXpNeededToNextLevel(computeXpNeededToNextLevel());
                setCurrentMana(getMaxMana() + 5);
            }
        }
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistribPoints() {
        return distribPoints;
    }

    public void setDistribPoints(int distribPoints) {
        this.distribPoints = distribPoints;
    }

    public int getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(int currentGold) {
        this.currentGold = currentGold;
    }
}
