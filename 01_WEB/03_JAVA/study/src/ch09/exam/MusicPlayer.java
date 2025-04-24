package ch09.exam;

public class MusicPlayer {
    public interface PlayResultListener {
        void onSuccess(String title);
        void onError(String title, int errorCode);
    }

    public void play(String title, boolean isSuccess, PlayResultListener listener) {
        if(isSuccess) {
            listener.onSuccess(title);
        } else {
            listener.onError(title, 500);
        }
    }
}
