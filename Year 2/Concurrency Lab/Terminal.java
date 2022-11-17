import java.lang.Math;
public class Terminal implements Runnable {
    private ConcertHall concertHall;
    private String name;
    private int sleepScaler = 2500;
    Terminal(ConcertHall library, String name){
        this.concertHall = library;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            double random = Math.random();
            long sleepTime = (long) (random*sleepScaler);
            int seatNumber = (int) Math.round(random);
            System.out.println("This is: " + name);
            System.out.println(name + " will sleep for: " + sleepTime);
            Thread.sleep(sleepTime);
            System.out.println(name + " is trying to book: " + seatNumber);
            concertHall.bookSeat(name, seatNumber);

            concertHall.release(name, seatNumber);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Arrival Thread");
            return;
        }
    }

}
