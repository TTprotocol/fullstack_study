package ch16.exam.metamong;

import ch16.exam.framework.Ticket;

public class MetaMonTicket extends Ticket {
    private String owner;

    public MetaMonTicket(String owner) {
        System.out.println(owner + "님의 메타몽 티켓을 발급합니다.");
        this.owner = owner;
    }

    @Override
    public void enter() {
        System.out.println("[MetaMonTicket:" + owner + "]님이 입장하였습니다.");
    }

    @Override
    public String toString() {
        return "[MetaMonTicket:" + owner + "]";
    }
}
