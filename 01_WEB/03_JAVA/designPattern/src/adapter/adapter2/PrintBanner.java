package adapter.adapter2;

import adapter.adapter1.Banner;

public class PrintBanner extends Print {
    private Banner banner;    // 위임 객체

    public PrintBanner(String title) {
        this.banner = new Banner(title);
    }

    // 배너 자체를 주입받아서 DI를 구현한다.
    public PrintBanner(Banner banner) {
        this.banner = banner;
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
