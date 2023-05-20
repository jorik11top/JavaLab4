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
    public int getFloorNow()
    {
            return floorNow;

    }
    public  int up() {
        if(floorNow < countFloors){
            floorNow++;
            return 1;
        }
        else{
            return -1;
        }
    }
    public  int down()  {
        if(floorNow > 1){
            floorNow--;
            return 1;
        }
        else{
            return -1;
        }
    }
    public int getSumTime(Request request){
       return requests.size()*4000+Math.abs(request.getNowFloor()-floorNow)*1000;
    }

    public  void move(){
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
            }
            else{
                
            }
        }
    }
}
