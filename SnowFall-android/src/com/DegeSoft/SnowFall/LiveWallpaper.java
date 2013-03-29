package com.DegeSoft.SnowFall;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;

public class LiveWallpaper extends AndroidLiveWallpaperService
{
	@Override
	public AndroidApplicationConfiguration createConfig()
	{
    	AndroidApplicationConfiguration config =  new AndroidApplicationConfiguration();
//    	config.useGL20 = true;
    	config.useAccelerometer = false;
    	config.useCompass = false;
//    	config.numSamples = 2;
        return config;
	}

	@Override
	public void offsetChange (ApplicationListener listener, float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset)
	{
//    	Gdx.app.log("LiveWallpaper", "offset changed: " + xOffset + ", " + yOffset);
	}

	@Override
	public ApplicationListener createListener(boolean arg0)
	{
		return new SnowFall();
	}
}
