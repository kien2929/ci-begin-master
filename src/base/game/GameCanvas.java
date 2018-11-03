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
    public static ArrayList<PlayerBullet> bullets;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<EnemyBullet> enemyBullets;
    //thêm 2 mảng enemy và enemybullet

    public GameCanvas(){
        this.background = new Background();
        this.player = new Player();
        GameCanvas.bullets = new ArrayList<>();
        GameCanvas.enemies = new ArrayList<>();
        GameCanvas.enemyBullets= new ArrayList<>();

        Enemy enemy = new Enemy();
        GameCanvas.enemies.add(enemy);
        Enemy enemy1 = new Enemy();
        enemy1.position.set(50,0);
        Enemy enemy2 = new Enemy();
        enemy2.position.set(100,0);

        GameCanvas.enemies.add(enemy1);
        GameCanvas.enemies.add(enemy2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.background.render(g);
        this.player.render(g);
        for(PlayerBullet bullet: bullets){
            bullet.render(g);
        }
        for(Enemy enemy: enemies){
            enemy.render(g);
        }
        for(EnemyBullet enemybullet: enemyBullets){
            enemybullet.render(g);
        }
    }

    public void gameLoop(){
        int delay = 1000/60;
        long lastRun = 0;
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastRun > delay) {
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void runAll() {
        this.background.run();
        this.player.run();
        for(PlayerBullet bullet : bullets){
            bullet.run();
        }
        for(Enemy enemy: enemies){
            enemy.run();
        }
        for(EnemyBullet enemyBullet: enemyBullets){
            enemyBullet.run();
        }
    }
    public void renderAll(){
        this.repaint();
    }
}

