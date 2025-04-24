package ch09.exam;

public class PlaybackLogger {

    public void log(String title, String artist) {

        class RecentLog {
            private String title;
            private String artist;

            public RecentLog(String title, String artist) {
                this.title = title;
                this.artist = artist;
            }

            void printLog() {
                System.out.println("🎼 최근 재생: " + title + " - " + artist + ((title.length() >= 10 || artist.length() >= 10 ) ? " (인기곡)" : ""));
            };
        }


        RecentLog recentLog = new RecentLog(title, artist);
        recentLog.printLog();
    }
}
