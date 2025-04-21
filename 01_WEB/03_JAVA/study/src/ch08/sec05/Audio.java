package ch08.sec05;

public class Audio implements RemoteControl {
    private int volume;
    private int memoeyVolume;

    //turnOn() 추상 메소드 오버라이딩 @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    //turnOff() 추상 메소드 오버라이딩 @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > ch08.sec04.RemoteControl.MAX_VOLUME) {
            this.volume = ch08.sec04.RemoteControl.MAX_VOLUME;

        } else if (volume < ch08.sec04.RemoteControl.MIN_VOLUME) {
            this.volume = ch08.sec04.RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 Audio 볼륨: " + volume);
    }


}
