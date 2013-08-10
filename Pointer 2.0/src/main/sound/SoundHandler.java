package main.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import main.Main;

public class SoundHandler {
	public static synchronized void playSoundLaser(final String url) {
	    try {
	      Clip clip = AudioSystem.getClip();
	      AudioInputStream inputStream = AudioSystem.getAudioInputStream(
	      Main.class.getResourceAsStream("../" + url));
	      clip.open(inputStream);
	      FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	     gainControl.setValue(-20.0f); // Reduce volume by 40 decibels.
	     clip.start();
	    } catch (Exception e) {
	      System.err.println(e.getMessage());
	    }
	}
	public static synchronized void playSoundEngine(final String url)
	{
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(
					Main.class.getResourceAsStream("../" + url));
			clip.open(inputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-20.0f);
			clip.start();
			
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}
