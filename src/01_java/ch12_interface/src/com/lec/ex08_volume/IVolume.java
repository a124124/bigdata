package com.lec.ex08_volume;
// Speaker, TV, Radio 
public interface IVolume {
	public int SPEAKER_MAX_VOLUME = 100;
	public int TV_MAX_VOLUME = 30;
	public int RADIO_MAX_VOLUME = 50;
	public int MIN_VOLUME = 0;
	
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void mute() {
		System.out.println("무음 처리 합니다.");
	}
}
