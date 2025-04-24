package ch09.exam;

public class PlayerUI {
    public interface ClickListener {
        void onClick();
    }

    private ClickListener listener;

    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    public void clickPlayButton() {
        if (listener == null) {
            System.out.println("❌ 재생 전략이 설정되지 않았습니다.");
        } else {
            listener.onClick();
        }

    }
}
