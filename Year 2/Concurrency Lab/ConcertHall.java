public class ConcertHall {
    static final int MAX_AVAIALABLE = 2;
    private boolean[] seatsInUse = new boolean[MAX_AVAIALABLE];
    public synchronized void bookSeat(String name, int seatNumber) throws InterruptedException{



        while(areAllTrue()){
            wait();
        }
        reserve(seatNumber, name);
        notifyAll();




    }
    private boolean areAllTrue(){
        for(boolean b : seatsInUse) if(!b) return false;
        return true;
    }
    private void reserve(int seatNumber, String name) throws InterruptedException {
        if (seatsInUse[seatNumber] == false){
            seatsInUse[seatNumber] = true;
            System.out.println("ID: " + seatNumber + " has been reserved by " + name);

            double random = Math.random();
            long sleepTime = (long) (random*2000);
            System.out.println(name + " will sleep for: " + sleepTime);
            Thread.sleep(sleepTime);


        } else {
            System.out.println("ID: " + seatNumber + " is already booked.");
        }
    }
    public synchronized void release(String name, int seatNumber) throws InterruptedException{
        System.out.println(name + " is trying to release: " + seatNumber);
        seatsInUse[seatNumber] = false;
        System.out.println(name + " has released seat " + seatNumber);
        notifyAll();
    }
}
