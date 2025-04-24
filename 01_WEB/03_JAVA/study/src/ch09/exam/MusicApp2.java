package ch09.exam;

public class MusicApp2 {
    private String user = "yura";

    public static class PlayerUI {
        public void show(MusicApp2 musicApp) {
            System.out.println("🎧 현재 사용자: " + musicApp.user); // ❌ 컴파일 에러 발생
        }
    }

    public static void main(String[] args) {
        MusicApp2 musicApp2 = new MusicApp2();
        MusicApp2.PlayerUI ui = new MusicApp2.PlayerUI();
        ui.show(musicApp2);
    }
}
