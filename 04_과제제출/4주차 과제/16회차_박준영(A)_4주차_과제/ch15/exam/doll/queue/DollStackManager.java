package ch15.exam.doll.queue;

import java.util.Stack;

public class DollStackManager {
    public Stack<String> stack = new Stack<>();
    public String[] doll = {
            "피카츄", "리자몽", "꼬부기", "쿠로미", "헬로키티", "뽀로로", "짱구", "도라에몽", "스폰지밥", "미니언"
    };

    public void storeRandomDoll() {
        if (doll.length == 0) System.out.println("인형이 없습니다.");
        int random = (int) (Math.random() * doll.length);
        stack.push(doll[random]);
        System.out.println(doll[random] + " 인형이 보관함에 추가되었습니다.");
    }

    public void showStack() {
        System.out.println(stack.toString());
    }
}
