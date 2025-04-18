package ch06.sec08.exam01;

public class Carculator {

    public Carculator() {
    }

    //리턴값이 void면 리턴값이 없다
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    void powerOff() {
        System.out.println("전원을 끕니다");
    }

    // int 2개를 받아서 int를 리턴함.
    int plus(int x, int y) {
        int result = x + y;
        return result;
    }

    // int 2개를 받아서 double를 리턴함.
    double divide(int x, int y) {
        double result = (double) x / (double) y;
        return result;
    }

}
