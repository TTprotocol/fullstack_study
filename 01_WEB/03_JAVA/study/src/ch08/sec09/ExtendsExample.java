package ch08.sec09;

public class ExtendsExample {
    public static void main(String[] args) {
        InterfaceCImpl impl = new InterfaceCImpl();

        InterfaceA ia = impl;
        ia.methodA();   // 자기 자신의 메소드만 접근 가능
        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        // 부모 인터페이스의 메소드 접근 가능
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
