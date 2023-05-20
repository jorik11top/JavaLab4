import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Elevator elevator1 = new Elevator(20,1);
        Elevator elevator2 = new Elevator(20,2);

        ArrayList<Request> requests = new ArrayList<>();
        RequestThread a = new RequestThread(requests,6000);
        a.start();
        Thread.sleep(25000);
        a.offWork();
    }
}
