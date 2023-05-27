import java.util.ArrayList;

public class Elevator {
    private final int countFloors;
    private int floorNow;
    private int numberElevator;
    private Status status = Status.STOP;
    ArrayList<Request> requests = new ArrayList<>();
    public Elevator(int countFloors,int numberElevator) {
        this.countFloors = countFloors;
        this.floorNow = 1;
        this.numberElevator = numberElevator;
    }
    public int getFloorNow() {
            return floorNow;
    }

    public int getCountFloors() {
        return countFloors;
    }

    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public int getNumberElevator(){
        return this.numberElevator;
    }

    public ArrayList<Request> getRequests(){
        return requests;
    }

    public  int up() {
        if(floorNow < countFloors){
            floorNow++;
            return floorNow;
        }
        else{
            return -1;
        }
    }

    public  int down()  {
        if(floorNow > 1){
            floorNow--;
            return floorNow;
        }
        else{
            return -1;
        }
    }

    public int getSumTime(Request request){
       return requests.size()*4000+Math.abs(request.getNowFloor()-floorNow)*1000;
    }

    public void addRequset(Request request){
        requests.add(request);
    }

    public  void move() throws InterruptedException {
        Request request;
        synchronized (requests){
            if(requests.isEmpty()){
                request = null;
            }
            else{
                request = requests.get(0);
                requests.remove(0);
            }
        }
        if (request == null){
            return;
        }
        if(request.getNowFloor() < floorNow){
            status = Status.DOWN;
        }
        else{
            status = Status.UP;
        }
        while (floorNow != request.getNowFloor()){
            if(status == Status.UP){
                up();
                Thread.sleep(1500);

            }
            else{

            }
        }
    }
}
