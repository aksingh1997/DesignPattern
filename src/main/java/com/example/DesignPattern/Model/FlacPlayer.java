package com.example.DesignPattern.Model;

public class FlacPlayer implements AdvancedMusicPlayer{

	@Override
	public String highQualityPlay(String fileFormat) {
		return "Playing high quality .flac songs";
	}

}
