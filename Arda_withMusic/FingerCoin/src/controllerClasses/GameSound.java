package controllerClasses;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.*;

import java.io.File;
public class GameSound{
	private Media media;
	private MediaPlayer player;
	private JFXPanel threadHandler;
	public GameSound(String song){
		threadHandler = new JFXPanel();
		media = new Media(new File(song).toURI().toString());
		player = new MediaPlayer(media);
	}
	public void changeSound(double level){
		if( level == 0){
			player.setMute(true);
		}
		else{
			player.setVolume(level);
		}
	}
	public void stopMusic(){
		player.stop();
	}
	public void start(){
		player.setAutoPlay(true);
		player.play();
	}
}

