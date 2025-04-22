package adapter.adapter1;

public class Banner {
    // 소스 역할. (이용하고자 하는 코드)
    // 일반적으로는 라이브러리 형태로 가져오기 때문에 개발자가 수정할 수 없는 코드이다.
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
