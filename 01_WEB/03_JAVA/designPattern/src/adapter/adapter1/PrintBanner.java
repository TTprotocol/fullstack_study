package adapter.adapter1;

public class PrintBanner extends Banner implements Print{
    // 이용하고 싶은 코드를 상속받고, 사용자에게 맞추기 위해 인터페이스를 구현한다.
    // 문제 발생
    // 1. 생성자 문제 => 상속이 있기 때문에 부모에 default 생성자가 생겨야 하는데,
    // 생성자를 정의했기 때문에 defualt 생성자가 없기 때문에 에러가 난다.
    // 2. 인터페이스 구현 문제 => Print의 추상 메서드를 구현해야 한다.

    public PrintBanner(String string) {
        // 부모 생성자를 호출한다.
        // 직접 호출하지 않으면 자동으로 super()가 호출되기 때문에 에러가 발생한다.
        // 반드시 존재하는 부모 생성자를 호출해야 한다.
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
