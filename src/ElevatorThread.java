public class ElevatorThread extends Thread{
    Elevator elevator;
    boolean work = true;
    public ElevatorThread(Elevator elevator) {
        this.elevator = elevator;
    }

    public void offWork(){
        work = false;
    }

    public void addRequest(Request request){
        elevator.addRequset(request);
    }
    @Override
    public void run(){
        while (work){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (elevator.getRequests()){
                if(elevator.getRequests().size() == 0){
                    continue;
                }
            }
            Request request = elevator.getRequests().remove(0);
            elevator.setStatus(request.getStatus());
            do {
                if(elevator.getFloorNow() > request.getNowFloor()){
                    elevator.down();
                    System.out.println("Лифт №"+elevator.getNumberElevator()+" на этаже "+elevator.getFloorNow() + " статус "+ elevator.getStatus());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    for (int i = 0; i <elevator.getRequests().size(); i++) {
                        if(elevator.getRequests().get(i).getNowFloor() == elevator.getFloorNow() && elevator.getRequests().get(i).getStatus() == elevator.getStatus()){
                            Request req = elevator.getRequests().remove(i);
                            System.out.println("Лифт №"+elevator.getNumberElevator()+" выполнил заявку"+ req.getStatus()+req.getNowFloor());
                        }
                    }
                }
                else if(elevator.getFloorNow() < request.getNowFloor()){
                    elevator.up();
                    System.out.println("Лифт №"+elevator.getNumberElevator()+" на этаже "+elevator.getFloorNow() + " статус "+ elevator.getStatus());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    for (int i = 0; i <elevator.getRequests().size(); i++) {
                        if(elevator.getRequests().get(i).getNowFloor() == elevator.getFloorNow() && elevator.getRequests().get(i).getStatus() == elevator.getStatus()){
                            Request req = elevator.getRequests().remove(i);
                            System.out.println("Лифт №"+elevator.getNumberElevator()+" выполнил заявку"+ req.getStatus()+req.getNowFloor());
                        }
                    }
                }
                else {
                    System.out.println("Лифт №"+elevator.getNumberElevator()+" выполнил заявку"+ request.getStatus()+request.getNowFloor());
                    for (int i = 0; i <elevator.getRequests().size(); i++) {
                        if(elevator.getRequests().get(i).getNowFloor() == elevator.getFloorNow() && elevator.getRequests().get(i).getStatus() == elevator.getStatus()){
                            Request req = elevator.getRequests().remove(i);
                            System.out.println("Лифт №"+elevator.getNumberElevator()+" выполнил заявку"+ req.getStatus()+req.getNowFloor());
                        }
                    }
                    if(!elevator.getRequests().isEmpty()){
                        request = elevator.getRequests().remove(0);
                        elevator.setStatus(request.getStatus());
                    }
                    else{
                        break;
                    }
                }
            }while (true);
            elevator.setStatus(Status.STOP);


        }
    }
}
