package base.game;

import base.Background;
import base.GameObject;
import base.enemy.Enemy;
import base.enemy.EnemyBullet;
import base.player.Player;
import base.player.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    public GameObject background;
    public GameObject player;
//    public static ArrayList<PlayerBullet> bullets = new ArrayList<>();
//    public static ArrayList<Enemy> enemies = new ArrayList<>();
//    public static ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();
//    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    //thêm 2 mảng enemy và enemybullet

    public GameCanvas() {
        this.background = GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);

        Enemy enemy = GameObject.recycle(Enemy.class);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //for (GameObject.gameObjects:GameObject.gameObjects){
        for(int i=0;i<GameObject.gameObjects.size();i++){
            GameObject gameObject=GameObject.gameObjects.get(i);
            if (gameObject.isActive){
                gameObject.render(g);
            }
        }
    }

    public void gameLoop() {
        int delay = 1000 / 60;
        long lastRun = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastRun > delay) {
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void renderAll() {
        this.repaint();
    }

    public void runAll() {
        for (int i=0;i<GameObject.gameObjects.size();i++){
            GameObject gameObject=GameObject.gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.run();
            }
        }
    //    System.out.println(GameObject.gameObjects.size());
    }
}



