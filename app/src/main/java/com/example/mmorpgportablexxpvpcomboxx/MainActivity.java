package com.example.mmorpgportablexxpvpcomboxx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView playerName;
    private TextView playerLevel;
    private TextView monsterName;
    private TextView goldAmount;
    private TextView strengthButton;
    private TextView intelligenceButton;
    private TextView distribPoints;

    private ImageButton aquaButton;
    private ImageButton flameButton;

    private ProgressBar playerLife;
    private ProgressBar playerMana;
    private ProgressBar monsterLife;

    private ImageButton monsterButton;

    private Monster slime;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        playerName = findViewById(R.id.playerName);
        playerLevel = findViewById(R.id.playerLevel);
        monsterName = findViewById(R.id.monsterName);
        goldAmount = findViewById(R.id.goldAmount);
        strengthButton = findViewById(R.id.strengthButton);
        intelligenceButton = findViewById(R.id.intelligenceButton);
        distribPoints = findViewById(R.id.distribPoints);

        aquaButton = findViewById(R.id.aquaButton);
        flameButton = findViewById(R.id.flameButton);

        playerLife = findViewById(R.id.playerLife);
        playerMana = findViewById(R.id.playerMana);
        monsterLife = findViewById(R.id.monsterLife);

        monsterButton = findViewById(R.id.monsterButton);

        player = new Player("Misterblor");
        slime = new Monster();

        playerName.setText(player.getName());
        playerLevel.setText(player.levelToString());

        goldAmount.setText(Integer.toString(player.getCurrentGold()) + " GOLD");

        distribPoints.setText(Integer.toString(player.getDistribPoints()) + " Points");

        strengthButton.setText(Integer.toString(player.getStr()) + " STR");
        intelligenceButton.setText(Integer.toString(player.getIntelligence()) + " INT");

        monsterName.setText(slime.toString());

        System.out.println(player.getPercentageHealth());
        playerLife.setProgress(player.getPercentageHealth());
        playerMana.setProgress(player.getPercentageMana());
        monsterLife.setProgress(slime.getPercentageHealth());

        monsterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int lifeUpdate = slime.getCurrentHealth() - player.getAtk();
                if (lifeUpdate <= 0){
                    monsterDeath();
                } else {
                    slime.setCurrentHealth(lifeUpdate);
                }
                monsterLife.setProgress(slime.getPercentageHealth());
                monsterName.setText(slime.toString());
            }
        });

        strengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.getDistribPoints() > 0){
                    player.setStr(player.getStr() + 1);
                    player.setAtk((int) (player.getStr() * 1.5));
                    player.setDistribPoints(player.getDistribPoints() - 1);
                    strengthButton.setText(Integer.toString(player.getStr()) + " STR");
                    distribPoints.setText(Integer.toString(player.getDistribPoints()) + " Points");
                }
            }
        });

        intelligenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.getDistribPoints() > 0){
                    player.setIntelligence(player.getIntelligence() + 1);
                    player.setDistribPoints(player.getDistribPoints() - 1);
                    intelligenceButton.setText(Integer.toString(player.getIntelligence()) + " INT");
                    distribPoints.setText(Integer.toString(player.getDistribPoints()) + " Points");
                }
            }
        });

        aquaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.getCurrentMana() >= 10) {
                    int lifeUpdate = (int) (slime.getCurrentHealth() - (player.getIntelligence() * 1.2));
                    player.setCurrentMana(player.getCurrentMana() - 10);
                    if (lifeUpdate <= 0) {
                        monsterDeath();
                    } else {
                        slime.setCurrentHealth(lifeUpdate);
                    }

                    playerMana.setProgress(player.getPercentageMana());
                    monsterLife.setProgress(slime.getPercentageHealth());
                    monsterName.setText(slime.toString());
                }
            }
        });

        flameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.getCurrentMana() >= 10) {
                    int lifeUpdate = (int) (slime.getCurrentHealth() - (player.getIntelligence() * 1.2));
                    player.setCurrentMana(player.getCurrentMana() - 10);
                    if (lifeUpdate <= 0) {
                        monsterDeath();
                    } else {
                        slime.setCurrentHealth(lifeUpdate);
                    }

                    playerMana.setProgress(player.getPercentageMana());
                    monsterLife.setProgress(slime.getPercentageHealth());
                    monsterName.setText(slime.toString());
                }
            }
        });
    }

    private void monsterDeath(){
        slime.setCurrentHealth(0);
        player.recieveXp(slime.getXpDropped());
        player.setCurrentGold(player.getCurrentGold() + slime.getGoldDropped());
        playerLevel.setText(player.levelToString());
        goldAmount.setText(Integer.toString(player.getCurrentGold()) + " GOLD");
        distribPoints.setText(Integer.toString(player.getDistribPoints()) + " Points");
        slime = null;
        slime = new Monster();
    }

    @Override
    protected void onResume() {
        super.onResume();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}