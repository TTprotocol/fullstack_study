package ch09.exam;

public class PlayerSettings {
    static class Mode{
        private boolean shuffle = false;
        private boolean repeat = false;
        private int volumeLevel = 5;

        private static final Mode instance = new Mode();

        public static void printSettings() {
            System.out.println("\uD83C\uDF9B 현재 재생 설정 상태");
            System.out.println("- Shuffle: " + (instance.shuffle ? "ON" : "Off"));
            System.out.println("- Repeat: " + (instance.repeat ? "ON" : "Off"));
            System.out.println("- Volume: " + instance.volumeLevel);
            System.out.println();
        }

        public static void setShuffle(boolean value) {
            instance.shuffle = value;
            System.out.println("Shuffle 모드가 " + (value ? "ON" : "OFF") + "으로 설정되었습니다.");
        }

        public static void setRepeat(boolean value) {
            instance.repeat = value;
            System.out.println("Shuffle 모드가 " + (value ? "ON" : "OFF") + "으로 설정되었습니다.");
        }

        public static void setVolumeLevel(int level) {
            if (level < 0 || level > 10) {
                System.out.println("볼륨은 0~10 사이로 설정해야 합니다.");
            } else {
                instance.volumeLevel = level;
                System.out.println("볼륨이 " + level + "로 설정되었습니다.");
            }
        }

        public static boolean isShuffle() {
            return instance.shuffle;
        }

        public static boolean isRepeat() {
            return instance.repeat;
        }

        public static int getVolumeLevel() {
            return instance.volumeLevel;
        }
    }
}
