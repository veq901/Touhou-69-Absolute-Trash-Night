package Reimu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Enemies.Enemy;

public class Bullet {
	private int xSpeed;
	private int ySpeed;
	private boolean destroyed = false;
	private Sprite spr;
	private int bulletDamage = 200;
	    
    public Bullet(float x, float y, int xSpeed, int ySpeed, Texture tx) {
    	spr = new Sprite(tx);
    	spr.setPosition(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    public void update() {
        spr.setPosition(spr.getX()+xSpeed, spr.getY()+ySpeed);
        if (spr.getX() < 0 || spr.getX()+spr.getWidth() > Gdx.graphics.getWidth()) {
            destroyed = true;
        }
        if (spr.getY() < 0 || spr.getY()+spr.getHeight() > Gdx.graphics.getHeight()) {
        	destroyed = true;
        }
        
    }
    
    public void draw(SpriteBatch batch) {
    	spr.draw(batch);
    }
    
    public boolean checkCollision(Enemy e) {
        if(spr.getBoundingRectangle().overlaps(e.getSpr().getBoundingRectangle())){
        	// Se destruyen ambos
            this.destroyed = true;
            e.setHealth(e.getHealth() - bulletDamage);
            return true;

        }
        return false;
    }
    
    public boolean isDestroyed() {return destroyed;}
	
}