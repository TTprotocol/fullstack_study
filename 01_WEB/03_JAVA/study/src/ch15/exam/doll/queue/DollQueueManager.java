package ch15.exam.doll.queue;

import java.util.LinkedList;
import java.util.Queue;

public class DollQueueManager {
    Queue<String> queue = new LinkedList<>();

    // 고객 등록
    public void registerCustomer(String name) {
        queue.add(name);
    }

    // 첫 고객 뽑기 실행
    public String processNextCustomer() {
        String customer = queue.poll();
        if (customer != null) System.out.println(customer + " 님! 인형 뽑기 하러 오세요!");
        return customer;
    }

    // 현재 대기열 출력
    public void showWaitingList() {
        System.out.println(queue);
    }

    public String getNextCustomer() {
        if (queue.isEmpty()) return null;
        return queue.poll();
    }
}
