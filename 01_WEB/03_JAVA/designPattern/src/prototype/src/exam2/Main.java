package exam2;

import exam2.framework.Manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.register("insta", new CardTemplate("Instagram Story", "*"));
        manager.register("twit", new CardTemplate("Tweet Style", "-"));
        manager.register("short", new CardTemplate("YouTube Shorts", "#"));

boolean loop = true;

        while(loop) {
            Scanner sc = new Scanner(System.in);
            String scan =sc.nextLine();


        }
    }
}
