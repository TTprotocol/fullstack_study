package ch06.sec14;

public class Car {
    private int speed;
    private boolean stop;

    public Car() {
    }

    public Car(int speed, boolean stop) {
        this.speed = speed;
        this.stop = stop;
    }

    // Getter : 값을 반환하는 메서드
    public int getSpeed() {
        return speed;
    }

    // Setter : 값을 설정하는 메서드
    public void setSpeed(int speed) {
        if (speed < 0) this.speed = 0;  // 0이하의 값은 들어오지 못하게 설정
        else this.speed = speed;
    }

    // boolean 타입의 경우 getter에 is를 사용한다.
    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop) this.speed = 0;
    }
}
