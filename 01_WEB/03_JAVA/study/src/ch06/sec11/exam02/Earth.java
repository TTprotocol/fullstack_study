package ch06.sec11.exam02;

public class Earth {
    static final double RADIUS = 64000;

    // 상수는 초기화 필요
    static final double SURFACE;

    static {
        SURFACE = 4 * Math.PI * RADIUS * RADIUS;
    }
}
