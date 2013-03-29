package com.DegeSoft.SnowFall;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlakesState
{
	protected FlakesField field;
	
	public FlakesState()
	{
		field =  new FlakesField();
	}
	
	public void render(SpriteBatch batch)
	{
		field.render(batch);
	}
	
	public void update(int deltaMS)
	{
		field.update(deltaMS);
	}
	
	public void dispose()
	{
		field.dispose();
	}
	
	public void resize(int width, int height)
	{
		field.resize(width, height);
	}
}
