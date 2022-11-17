public class Seats {
    public static void main(String[] args) throws InterruptedException {
        ConcertHall concertHall = new ConcertHall();
        Terminal s1 = new Terminal(concertHall, "t1");
        Terminal s2 = new Terminal(concertHall, "t2");
        Terminal s3 = new Terminal(concertHall, "t3");
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
