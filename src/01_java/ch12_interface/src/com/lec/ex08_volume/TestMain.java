package com.lec.ex08_volume;

public class TestMain {
	public static void main(String[] args) {
		Radio radio = new Radio();
		TV tv = new TV(5);
		Speaker speaker = new Speaker(20);
		radio.volumeDown();
		tv.volumeUp(20);
		speaker.volumeUp(80);
		IVolume[] device = {radio, tv, speaker};
		for(IVolume i : device) {
			i.volumeUp(10);
		}
		for(int idx = 0; idx < device.length; idx++) {
			device[idx].volumeDown(10);
		}
		tv.mute();
		
	}
}
