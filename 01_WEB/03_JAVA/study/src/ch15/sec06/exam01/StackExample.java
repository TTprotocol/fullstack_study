package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Coin> coinBox = new Stack<>();
        
        // push : 스택에 값을 넣어주는 메서드
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));
        
        // isEmpty() : 스택이 비어있는지 확인하는 메서드
        while(!coinBox.isEmpty()) {
            // pop : stack에서 마지막에 넣어준 값을 꺼내주는 메서드
            Coin coin = coinBox.pop();
            System.out.println("꺼내온 동전 : " + coin.getValue() + "원");            
        }
    }
}
