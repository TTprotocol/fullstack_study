package ch15.exam.quiz;

public class QuizMain {
    public static void main(String[] args) {
//
//        String data = """
//            초인종이 없을 때를 두 글자로 줄이면? - 노벨
//            보라돌이 나나 뽀가 자기들끼리 식사할 때 두비가 하는 말은? - 뚜비두밥
//            등산을 좋아하는 왕은? - 하이킹
//            고등학생이 싫어하는 나무는? - 야자나무
//            포도가 자기소개할 때 하는 말은? - 포도당
//            신데렐라가 잠을 못 자면? - 모짜렐라
//            <옷장 안에 불이 났다>를 다섯 글자로 하면? - 장안의 화재
//            호랑이가 차를 타고 가다가 친구를 만나서 하는 말은? - 타이거
//            몸이 아파도 반드시 가야 하는 대학교는? - 가야대
//            인사하면서 웃으면? - 하이킥
//            자동차를 톡하고 치면? - 카톡
//            <이것이 코다>를 세 글자로 줄이면? - 디스코
//            소녀가 강으로 여행을 가면? - 걸리버 여행
//            소고기가 없는 나라는? - 소고기무국
//            드라큘라가 가장 싫어하는 사람은? - 찔러도 피 안 나는 사람
//            때돈을 버는 곳은? - 목욕탕
//            자동차 키 색은? - 카키색
//            해와 달 중, 해만 취재하는 사람은? - 해리포터
//            입이 S자로 되어있으면? - EBS
//            신문이 일하러 가면? - 일간신문
//            """;
//
//        QuizBox<Quiz> quizBox = new QuizBox<>();
//        quizBox.parse(data);
//        quizBox.printAll();

        QuizBox<Quiz> quizBox = new QuizBox<>();
        quizBox.add(new Quiz("바나나가 웃으면?", "바나나킥"));
        quizBox.add(new Quiz("자동차가 뒤로 가면?", "트럭"));
        quizBox.add(new Quiz("세상에서 가장 빠른 새는?", "눈 깜짝할 새"));

        System.out.println("=== 삭제 전 문제 목록 ===");
        quizBox.printAll();

        // 1. static 메소드 removeFromBox() 사용
        Quiz quizToDelete = new Quiz("자동차가 뒤로 가면?", "트럭");
        QuizBox.removeFromBox(quizBox, quizToDelete);

        System.out.println("\\n=== removeFromBox() 사용 후 문제 목록 ===");
        quizBox.printAll();

        // 2. 인스턴스 메소드 remove() 사용
        Quiz anotherQuizToDelete = new Quiz("바나나가 웃으면?", "바나나킥");
        boolean removed = quizBox.remove(anotherQuizToDelete);

        if (removed) {
            System.out.println("\\n바나나 문제가 정상적으로 삭제되었습니다.");
        } else {
            System.out.println("\\n바나나 문제 삭제에 실패했습니다.");
        }

        System.out.println("\\n=== remove() 사용 후 최종 문제 목록 ===");
        quizBox.printAll();
    }
}
