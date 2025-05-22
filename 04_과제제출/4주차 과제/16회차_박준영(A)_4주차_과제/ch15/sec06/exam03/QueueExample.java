package ch15.sec06.exam03;

import ch15.sec06.exam03.command.Command;
import ch15.sec06.exam03.command.SendKakaotalkCommand;
import ch15.sec06.exam03.command.SendMailCommand;
import ch15.sec06.exam03.command.SendSmsCommand;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Map<String, Command> commands = new LinkedHashMap<>();
        commands.put("sendMail", new SendMailCommand());
        commands.put("sendSMS", new SendSmsCommand());
        commands.put("sendKakaotalk", new SendKakaotalkCommand());

        Queue<Message> messageQueue = new LinkedList<>();

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));

        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();
            
            // Command 호출
            Command command = commands.get(message.command);
            if (command != null) command.execute(message);
        }   // 이제 내용이 추가되어도 여기서의 변화는 없다.
    }
}
