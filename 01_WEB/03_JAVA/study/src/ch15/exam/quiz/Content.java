package ch15.exam.quiz;

public class Content {
    String question;

    public Content(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public boolean equals(Object obj) {
        return obj.equals(question);
    }
}
