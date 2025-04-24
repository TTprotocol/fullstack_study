package ch09.exam;

public class AppMain {
    public static void main(String[] args) {
//        GenrePlaybackManager manager = new GenrePlaybackManager();
//
//        // HIPHOP 전략
//        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
//            // TODO: 제목 길이가 8자 이상이면 💥💥💥, 아니면 💥 출력
//
//            @Override
//            public void play(String title, String artist) {
//                String effect = "";
//                if (title.length() >= 8) {
//                    effect = "\uD83D\uDCA5\uD83D\uDCA5\uD83D\uDCA5";
//                } else {
//                    effect = "\uD83D\uDCA5";
//                }
//                System.out.println(effect + " " + title + " - " + artist + " (힙합 스타일)");
//            }
//        });
//        manager.play("Drowning", "WOODZ");
//
//        // BALLAD 전략
//        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
//            // TODO: 아티스트 이름에 공백이 있으면 🎵🎵, 없으면 🎵 출력
//
//            @Override
//            public void play(String title, String artist) {
//                String effect = "";
//                if (artist.contains(" ")) {
//                    effect = "\uD83C\uDFB5\uD83C\uDFB5";
//                } else {
//                    effect = "\uD83C\uDFB5";
//                }
//                System.out.println(effect + " " + title + " - " + artist + " (감성 발라드)");
//            }
//        });
//        manager.play("그녀가 웃잖아", "LUCY");
//
//        // POP 전략
//        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
//            // TODO: 제목 + 아티스트 글자 수가 짝수면 🎧🎧, 홀수면 🎧 출력
//
//            @Override
//            public void play(String title, String artist) {
//                String effect = "";
//                if ((title.length() + artist.length()) % 2 == 0) {
//                    effect = "\uD83C\uDFA7\uD83C\uDFA7";
//                } else {
//                    effect = "\uD83C\uDFA7";
//                }
//                System.out.println(effect + " " + title + " - " + artist + " (대중가요 스타일)");
//            }
//        });
//        manager.play("오늘만 I LOVE YOU", "BOYNEXTDOOR");

//        PlayerUI ui = new PlayerUI();
//
//        // ✅ 전역 모드 설정
//        PlayerSettings.Mode.setShuffle(true);
//        PlayerSettings.Mode.setRepeat(false);
//
//        // ✅ 익명 구현 객체로 리스너 등록
//        ui.setClickListener(new PlayerUI.ClickListener() {
//            @Override
//            public void onClick() {
//                // TODO: 셔플 모드일 경우 "🔀 셔플 모드로 재생합니다." 출력
//                // TODO: 반복이 꺼져 있을 경우 "⏭ 반복 없이 한 번만 재생합니다." 출력
//                // TODO: 위 두 조건이 모두 아니면 "▶ 일반 모드로 재생합니다." 출력
//
//                boolean shuffle = PlayerSettings.Mode.isShuffle();
//                boolean repeat = PlayerSettings.Mode.isRepeat();
//
//                if (shuffle) {
//                    System.out.println("🔀 셔플 모드로 재생합니다.");
//                } else {
//                    System.out.println("🔀 셔플 없이 순서대로 재생합니다.");
//                }
//                if (repeat) {
//                    System.out.println("반복 재생합니다.");
//                } else {
//                    System.out.println("⏭ 반복 없이 한 번만 재생합니다.");
//                }
//
//                if (!shuffle && !repeat) {
//                    System.out.println("▶ 일반 모드로 재생합니다.");
//                }
//            }
//        });
//
//        // ✅ 버튼 클릭 시 동작
//        ui.clickPlayButton();

//        PlaybackLogger logger = new PlaybackLogger();
//
//        logger.log("사건의 지평선", "윤하");
//        logger.log("오늘만 I LOVE YOU", "BOYNEXTDOOR");
//        logger.log("Ditto", "NewJeans");

//        MusicPlayer player = new MusicPlayer();
//
//        player.play("Ditto", true, new MusicPlayer.PlayResultListener() {
//            // TODO: 여기에서 onSuccess와 onError 메서드를 구현하세요.
//            // 성공 시: "✅ 재생 성공: 제목"
//            // 실패 시: "❌ 재생 실패: 제목 - 오류 코드 코드"
//
//            @Override
//            public void onSuccess(String title) {
//                System.out.println("재생 성공 : " + title);
//            }
//
//            @Override
//            public void onError(String title, int errorCode) {
//                System.out.println("재생 실패 : " + title + " - 오류 코드 " + errorCode);
//            }
//        });
//
//        player.play("Attention", false, new MusicPlayer.PlayResultListener() {
//            // TODO: 위와 동일하게 onSuccess와 onError 메서드를 구현하세요.
//
//            @Override
//            public void onSuccess(String title) {
//                System.out.println("재생 성공 : " + title);
//            }
//
//            @Override
//            public void onError(String title, int errorCode) {
//                System.out.println("재생 실패 : " + title + " - 오류 코드 " + errorCode);
//            }
//        });

        Playable legacy = new LegacyPlayerAdapter(new LegacyPlayer());
        Playable modern = new ModernPlayerAdapter(new ModernPlayer());

        legacy.play("Ditto");
        modern.play("bad song");
        legacy.play("사건의 지평선");
        modern.play("Attention");
    }
}
