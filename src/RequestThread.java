import java.util.ArrayList;
import java.util.Random;

public class RequestThread extends Thread{
    private ArrayList<Request> requests;
    private boolean work;
    private long interval;
    public RequestThread(ArrayList<Request> requests,long interval){
        this.requests = requests;
        this.interval = interval;
        this.work = true;
    }
    public void offWork(){
        work = false;
    }
    @Override
    public void run() {
        while (work){
            try {
                sleep(interval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Status[] trends = {Status.UP,Status.DOWN};
            int randomI = (int) (Math.random()*trends.length);
            Status randT = trends[randomI];
            Random a = new Random();
            Request request = new Request(a.nextInt(20)+1,randT);
            synchronized (requests){
                requests.add(request);
            }
            System.out.println(request.getNowFloor()+" "+request.getStatus());
        }
        System.out.println("Stop");
    }
}
