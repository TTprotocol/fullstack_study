package ch15.exam.quiz;

import java.util.Arrays;

public class QuizBox<T extends Quiz> {
    private T[] list;
    private int size;

    public QuizBox() {
        list = (T[]) new Quiz[5];
        size = 0;
    }

    public void addQuiz(T quiz) {
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[size++] = quiz;
    }

    public void parse(String list) {
        String[] quizList = list.split("\n");
        for (String quiz : quizList) {
            String[] parts = quiz.split(" - ");
            if (parts.length == 2) {
                addQuiz((T) new Quiz(parts[0].trim(), parts[1].trim()));
            }
        }
    }

    public void printAll() {
        int count = this.size;

        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + list[count].getQuestion());
        }
    }
}
