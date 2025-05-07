package command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileService fs = new FileService();

        Command[] commands = {
//                new AddCommand(), // 1. 인스턴스
//                new Command() {
//                    @Override
//                    public void execute() {
//                        System.out.println("Add Command");
//                    }
//                },    // 2. 익명 구현 객채
                () -> System.out.println("Add Command"),    // 3. 람다식
//                new OpenCommand(),
                fs::open,   // () -> fs.open()
//                new PrintCommand(),
                fs::print,  // () -> fs.print()
//                new ExitCommand()
                Main::exit
        };

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1: Add, 2: Open, 3: Print, 4: Exit");
            System.out.print("선택: ");
            int sel = scanner.nextInt();

            commands[sel - 1].execute();
        }
    }

    // command 인터페이스와 동일함.
    // 매개변수 없음, 리턴 없음.
    public static void exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("종료할까요?(Y/n) ");
        String answer = scanner.nextLine();

        scanner.close();
        if (answer.isEmpty() || answer.equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }
}
