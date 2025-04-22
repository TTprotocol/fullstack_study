package ch09.exam;

public class GenrePlaybackManager {
    public interface GenrePlayer {
        void play(String title, String artist);
    }

    private GenrePlayer player;

    public void setPlayer(GenrePlayer player) {
        // 전략 주입
        this.player = player;
    };

    public void play(String title, String artist) {
        // 전략에 따른 재생 실행
        if (player == null) {
            System.out.println("❌ 재생 전략이 설정되지 않았습니다.");
        } else {
            player.play(title, artist);
        }
    }
}
