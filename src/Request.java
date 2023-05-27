public class Request {
    private final int nowFloor;
    private final Status trend;
    public Request(int nowFloor,Status trend){
        this.nowFloor = nowFloor;
        this.trend = trend;
    }

    public int getNowFloor() {
        return nowFloor;
    }

    public Status getStatus() {
        return trend;
    }

}
