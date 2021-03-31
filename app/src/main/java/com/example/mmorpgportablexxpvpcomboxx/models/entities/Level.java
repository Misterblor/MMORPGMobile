package com.example.mmorpgportablexxpvpcomboxx.models.entities;

public class Level {

    private int currentLevel;
    private int currentXp;
    private int xpNeededToNextLevel;

    public Level(int currentLevel, int currentXp, int xpNeededToNextLevel) {
        this.currentLevel = currentLevel;
        this.currentXp = currentXp;
        this.xpNeededToNextLevel = xpNeededToNextLevel;
    }

    private int computeXpNeededToNextLevel(){
        return (int)(xpNeededToNextLevel * 1.2);
    }

    public int recieveXp(int xp){
        int actualXp = xp;
        int nbLvlPassed = 0;
        while (actualXp > 0){
            if (currentXp + actualXp < xpNeededToNextLevel){
                currentXp += actualXp;
                break;
            } else if (currentXp + actualXp == xpNeededToNextLevel){
                currentXp = 0;
                currentLevel += 1;
                nbLvlPassed += 1;
                xpNeededToNextLevel = computeXpNeededToNextLevel();
                break;
            } else {
                actualXp -= xpNeededToNextLevel - currentXp;
                currentXp = 0;
                currentLevel += 1;
                nbLvlPassed +=1;
                xpNeededToNextLevel = computeXpNeededToNextLevel();
            }
        }
        return nbLvlPassed;
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
}
