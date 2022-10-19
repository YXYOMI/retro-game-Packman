package application.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * this class is used to turn on and turn off the background music.
 * @author Xinyi OUYANG / 20030865
 *
 */
public class Music {
	public MediaPlayer musicPlayer;
	
	/**
	 * Constructor. Get the music. and instantiate a music player.
	 */
	public Music() {
		String music = this.getClass().getClassLoader().getResource("inputFiles/bgm.mp3").toExternalForm();
		Media media = new Media(music);
		this.musicPlayer = new MediaPlayer(media);
	}
	
	/**
	 * Turn on the music.
	 */
	public void turnOn(){
		
		this.musicPlayer.play();
		this.musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	
	}
	
	
	/**
	 * Turn off the music.
	 */
	public void turnOff() {
		this.musicPlayer.stop();
	}
	
}
