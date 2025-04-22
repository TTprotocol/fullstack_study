package ch09.exam;

public class MusicApp {
    public String title = "";
    public String artist = "";
    public String type = "";

    public MusicApp(String title, String artist, String type) {
        this.title = title;
        this.artist = artist;
        this.type = type;
    }

    class MusicPlayer{
        void play() {
            String effect = getEffect(type);

            System.out.println(effect + " " + title + " - " + artist + " 을(를) 재생합니다. " + effect);
        }

        String getEffect(String genre) {
            if (genre.equals("HIPHOP")) {
                return "💥";
            } else if (genre.equals("BALLAD")) {
                return "🎵";
            } else {
                return "🎧";
            }
        }
    }

}
