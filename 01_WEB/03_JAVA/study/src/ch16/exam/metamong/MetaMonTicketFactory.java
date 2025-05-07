package ch16.exam.metamong;

import ch16.exam.framework.Ticket;
import ch16.exam.framework.TicketFactory;

public class MetaMonTicketFactory extends TicketFactory {

    @Override
    protected Ticket createTicket(String owner) {
        return new MetaMonTicket(owner);
    }

    @Override
    protected void registerTicket(Ticket ticket) {
        System.out.println("티켓 " + ticket + " 등록 완료");
    }
}
