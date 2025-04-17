package ch07.sec03.exam02;

public class SmartPhone extends Phone {
    public boolean wifi;

    //생성자 선언
    public SmartPhone(String model, String color) {
        // 부모에 기본 생성자가 없는 경우 명시적으로 호출
        // super : 부모 클래스를 의미
//        this.model = model;
//        this.color = color;

        super(model, color);
        System.out.println("자식 생성자 실행됨.");
    }

    //메소드 선언
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
        System.out.println("와이파이 상태를 변경했습니다.");
    }

    public void internet() {
        System.out.println("인터넷에 연결합니다.");
    }
}
