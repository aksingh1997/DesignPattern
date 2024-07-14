package com.example.DesignPattern.Model;

public class MP4Player implements AdvancedMusicPlayer{

	@Override
	public String highQualityPlay(String fileFormat) {
		return "playing high quality .mp4 songs";
	}

}
