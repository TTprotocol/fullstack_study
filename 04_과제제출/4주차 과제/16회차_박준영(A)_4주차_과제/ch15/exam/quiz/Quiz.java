package ch15.exam.quiz;

public class Quiz extends Content {
    String question;
    String answer;

    public Quiz(String question, String answer) {
        super(question);
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
