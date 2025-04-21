package ch08.sec09;

public class InterfaceCImpl implements InterfaceC {
    // 부모 인터페이스의 상위 인터페이스까지 구현해야 함
    public void methodA() {
        System.out.println("InterfaceCImpl-methodA() 실행");
    }

    public void methodB() {
        System.out.println("InterfaceCImpl-methodB() 실행");
    }

    public void methodC() {
        System.out.println("InterfaceCImpl-methodC() 실행");
    }
}
