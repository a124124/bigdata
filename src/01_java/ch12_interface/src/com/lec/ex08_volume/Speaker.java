package com.lec.ex08_volume;

public class Speaker implements IVolume {
	private int volumeLevel;
	public Speaker() {
		// TODO Auto-generated constructor stub
	}
	
	public Speaker(int volumeLevel) {
		super();
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() { //volumeLevel ?? 1??????Ű???? 100?϶? ??????Ű?? ?ʴ´?.
		// TODO Auto-generated method stub
		volumeLevel++;
		if(volumeLevel >= SPEAKER_MAX_VOLUME) {
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("?????? ?ִ?ġ?Դϴ?.");
		}else {
			System.out.println("?????? 1 ???????ϴ?. ???? ???? : " + volumeLevel);
		}
		
	}

	@Override
	public void volumeUp(int level) { //
		// TODO Auto-generated method stub
		volumeLevel += level;
		if(volumeLevel >= SPEAKER_MAX_VOLUME) {
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("?????? ?ִ?ġ?Դϴ?.");
		}else {
			System.out.printf("?????? %d ???????ϴ?. ???? ???? : %d\n", level, volumeLevel);
		}

	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		volumeLevel--;
		if(volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("?????Դϴ?.");
		}else {
			System.out.println("?????? 1 ???????ϴ?. ???? ???? : " + volumeLevel);
		}

	}

	@Override
	public void volumeDown(int level) {
		// TODO Auto-generated method stub
		volumeLevel -= level;
		if(volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("?????Դϴ?.");
		}else {
			System.out.printf("?????? %d ???????ϴ?. ???? ???? : %d\n", level, volumeLevel);
		}
	}

}
