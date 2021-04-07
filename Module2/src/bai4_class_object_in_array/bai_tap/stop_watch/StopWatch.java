package bai4_class_object_in_array.bai_tap.stop_watch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void startTime(long time ) {
        System.out.println(time);
    }

    public void start() {
         this.startTime =System.currentTimeMillis();
    }

    public void stop() {
         this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return this.endTime -  this.startTime;
    }
}
