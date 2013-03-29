package com.DegeSoft.SnowFall;

import java.util.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlakesField
{
	private List<SnowFlake> flakes = new LinkedList<SnowFlake>();
	private int width;
    private int height;
    private Texture flakeImage;
    
    public FlakesField()
    {
    	flakeImage = new Texture(Gdx.files.internal("data/snowflake.png"));
    	width = Gdx.graphics.getWidth();
    	height = Gdx.graphics.getHeight();
    	int flakesNumber = (width * height) / 2700;
    	for (int i = 0; i < flakesNumber; i++) {
    		flakes.add(new SnowFlake((float) (Math.random() * width), (float) (Math.random() * height), flakeImage));
        }
    }
    
    public void render(SpriteBatch batch)
    {

        for (SnowFlake f : flakes)
            f.render(batch);
    }
    
    public void update(int deltaMS)
    {
        for (SnowFlake f : flakes)
        {
            f.update(deltaMS);
            if(f.getY() > height)
            	f.reset((float) (Math.random() * width));
        }
    }
    
    public void dispose()
    {
//    	for (SnowFlake f : flakes)
//            f.dispose();
    	flakeImage.dispose();
    }
    
    public void resize(int width, int height)
    {
    	
    }
}
