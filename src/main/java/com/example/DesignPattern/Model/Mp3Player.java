package com.example.DesignPattern.Model;

public class Mp3Player implements MusicPlayer{
	
	// we are adapting new interface here with has-a relationship
	AdvancedMusicPlayer advancedMusicPlayer;
	
	@Override
	public String play(String fileFormat) {
		if(".mp3".equalsIgnoreCase(fileFormat) )
			return "Mp3 song playing!!!"; //this is legacy code which is supported
		else if(".mp4".equalsIgnoreCase(fileFormat))
			advancedMusicPlayer = new MP4Player(); // Now our code also handles new file formats, without changing anything at client's end
		else if(".flac".equalsIgnoreCase(fileFormat))
			advancedMusicPlayer = new FlacPlayer();
		else 
			return "incorrect file format";
		
		return advancedMusicPlayer.highQualityPlay(fileFormat);
	}
	
}
