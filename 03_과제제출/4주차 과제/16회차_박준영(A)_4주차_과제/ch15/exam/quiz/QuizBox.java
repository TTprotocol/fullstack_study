package ch15.exam.quiz;

import java.util.Arrays;

public class QuizBox<T extends Quiz> {
    private T[] list;
    private int size;

    public QuizBox() {
        list = (T[]) new Quiz[5];
        size = 0;
    }

//    public void addQuiz(T quiz) {
//        if (size == list.length) {
//            list = Arrays.copyOf(list, list.length * 2);
//        }
//        list[size++] = quiz;
//    }
//
//    public void parse(String list) {
//        String[] quizList = list.split("\n");
//        for (String quiz : quizList) {
//            String[] parts = quiz.split(" - ");
//            if (parts.length == 2) {
//                addQuiz((T) new Quiz(parts[0].trim(), parts[1].trim()));
//            }
//        }
//    }
//
//    public void printAll() {
//        for (int i = 0; i < size; i++) {
//            System.out.println((i + 1) + ". " + list[i].getQuestion());
//        }
//    }

    private void ensureCapacity() {
        if (size >= list.length) {
            int newCapacity = list.length * 2;
            T[] newList = (T[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
    }

    public void add(T content) {
        ensureCapacity();
        list[size++] = content;
    }

    public boolean remove(Content content) {
        int index = Arrays.asList(list).indexOf(content);

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        return true;
    }

    static <T extends Content> void removeFromBox(QuizBox<? super T> box, T quiz) {

    }

    public void printAll() {

    }
}
