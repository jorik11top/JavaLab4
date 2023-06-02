import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Elevator elevator1 = new Elevator(20,1);
        Elevator elevator2 = new Elevator(20,2);

        ArrayList<Request> requests = new ArrayList<>();
        ArrayList<Request> requestsPrint = new ArrayList<>();
        RequestThread a = new RequestThread(requests,6000);
        a.start();
        ElevatorThread el1 = new ElevatorThread(elevator1);
        ElevatorThread el2 = new ElevatorThread(elevator2);
        el1.start();
        el2.start();
        while (true){
            Thread.sleep(400);
            if (requests.size()==0){
                continue;
            }
            for (int i = 0; i < requests.size(); i++) {
                Request request = requests.remove(i);
                if(el1.elevator.getSumTime(request) <= el2.elevator.getSumTime(request))
                    el1.addRequest(request);
                else {
                    el2.addRequest(request);
                }
            }

        }
//        a.offWork();
//        Thread.sleep(6000);
        //test


    }
}
