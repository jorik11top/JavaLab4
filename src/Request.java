public class Request {
    private final int nowFloor;
    private final Trend trend;
    public Request(int nowFloor,Trend trend){
        this.nowFloor = nowFloor;
        this.trend = trend;
    }

    public int getNowFloor() {
        return nowFloor;
    }

    public Trend getTrend() {
        return trend;
    }

}
