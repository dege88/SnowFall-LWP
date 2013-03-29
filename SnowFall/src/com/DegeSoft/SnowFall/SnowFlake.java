package com.DegeSoft.SnowFall;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class SnowFlake
{
	protected float angle;
	protected float angleStep;
	protected float lateralPower;
	protected float fallSpeed;
//	protected Texture flakeImage;
	protected Sprite flakeSprite;
	protected float rotationSpeed;
	protected float scale = 1;
	protected int rotationSense;
	protected Rectangle flake;
	
	public SnowFlake(float x, float y, Texture flakeImage)
	{
		flake = new Rectangle();
		//flakeImage = new Texture(Gdx.files.internal("data/snowflake.png"));
		flake.height = flakeImage.getHeight();
		flake.width = flakeImage.getWidth();
		flakeSprite = new Sprite(flakeImage);
		reset(x);
		flake.y = y - flake.height / 2;
	}
	
	public void render(SpriteBatch batch)
	{
		flakeSprite.draw(batch);
	}
	
	public void update(int deltaMS)
	{
		flake.y += fallSpeed * deltaMS / 1000 * (0.9 + Math.random() / 5);
    	angle +=  rotationSense * angleStep * deltaMS / 100 * (0.9 + Math.random() / 5);
    	if(angle > Math.PI)
    		angle -= 2 * Math.PI;
    	if(angle < -Math.PI)
    		angle += 2 * Math.PI;
    	flakeSprite.rotate(rotationSense * rotationSpeed * deltaMS);
    	flakeSprite.setPosition(getX(), getY());
	}
	
	public float getX() {
        return (float) (flake.x + (seno(angle) * lateralPower));
    }

    public float getY() {
        return flake.y;
    }
    
    public void reset(float x) {
		flake.y = -flake.height;
		flake.x = x - flake.width / 2;
		
		angle = (float) (Math.random() * Math.PI);
		angleStep = (float) ((Math.random() * Math.PI / 16) + Math.PI / 32);
		lateralPower = (float) (Math.random() * 13 + 0.7);
		
		scale = (float) (Math.random() * 1.2 + 1.25);
		flakeSprite.setScale(scale);
		
		fallSpeed = (float) (Math.random() * 25 + 10);
		
		rotationSpeed = (float) (Math.random() * 360 / 4500 + 0.01);
		if(Math.random() >= 0.5)
			rotationSense = 1;
		else
			rotationSense = -1;
	}
    
    public void dispose()
    {
//    	flakeImage.dispose();
    }
    
    private float seno(float x)
    {
    	double B = (4 / Math.PI);
    	double C = (-4 / (Math.PI * Math.PI));
    	double y = B * x + C * x * Math.abs(x);

        return(float) (0.225 * (y * Math.abs(y) - y) + y);
    }
}
