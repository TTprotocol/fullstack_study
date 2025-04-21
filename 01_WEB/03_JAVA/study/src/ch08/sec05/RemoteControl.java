package ch08.sec05;

public interface RemoteControl {
    // 인터페이스의 필드는 기본적으로 상수(public static final 생략)
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    // 인터페이스의 메소드는 기본적으로 추상 메소드(public abstract 생략)
    void turnOn();

    void turnOff();

    void setVolume(int volume);

    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("무음 처리합니다.");
            setVolume(MIN_VOLUME);
        } else {
            System.out.println("무음 해제합니다.");
        }
    }
}
