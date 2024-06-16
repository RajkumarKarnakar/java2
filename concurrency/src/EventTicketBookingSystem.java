import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventTicketBookingSystem {
    private int availableTicket = 10;

    public synchronized void bookTicket(int numTickets) {
        if (numTickets <= availableTicket) {
            System.out.println(Thread.currentThread().getName() + " booking " + numTickets + " tickets with available " + availableTicket);
            availableTicket = availableTicket - numTickets;
            System.out.println(Thread.currentThread().getName() + " booked " + numTickets + " tickets with available " + availableTicket + " left \n");
        } else {
            System.out.println(Thread.currentThread().getName() + " could not book " + numTickets + " tickets. Not enough available. Available are: " + availableTicket);
        }

    }

    public int getAvailableTicket() {
        System.out.println(Thread.currentThread().getName() + " current available: " + availableTicket);
        return availableTicket;
    }

    public static void main(String[] args) {
        EventTicketBookingSystem bookingSystem = new EventTicketBookingSystem();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (bookingSystem.getAvailableTicket() > 0) {
            executorService.execute(() -> {
                bookingSystem.bookTicket(new Random().nextInt(5) + 1);
            });
        }
        executorService.shutdown();
    }
}

