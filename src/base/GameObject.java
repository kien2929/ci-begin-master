package base;

import base.player.Player;
import renderer.Renderer;
import sun.awt.image.BufferedImageDevice;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects=new ArrayList<>();
    public Vector2D position;
    public Renderer renderer;
    public boolean isActive;
    public Vector2D velocity;
    //createGameObject
    public GameObject(){
        this.position=new Vector2D();
        this.velocity=new Vector2D();
        this.isActive=true;

    }
    public void destroy(){ this.isActive=false; }

    public void reset(){ this.isActive=true; }

    public void run(){
        this.position.addThis(this.velocity);
    }
    public static <E extends GameObject> E create(Class<E>clazz){
    try {
        E gameObject = clazz.newInstance();
        gameObjects.add(gameObject);
        return gameObject;
    } catch(Exception ex){
        return null;
        }

    }
    //recycle
    public static <E extends GameObject> E recycle(Class<E> clazz){
        for(GameObject gameObject: gameObjects){
            if(isValueRecycle(gameObject, clazz)){
                gameObject.reset();
                return (E)gameObject;
            }
        }
        E newGameObject = create(clazz);
        return newGameObject;
    }

    private static boolean isValueRecycle(GameObject gameObject,Class clazz){

        return !gameObject.isActive && gameObject.getClass().isAssignableFrom(clazz);
    }

    public void render(Graphics g){
        if(this.renderer !=null){
            this.renderer.render(g,this);
        }

    }
}
