package L4_Class_ObjectInArray.BaiTap.StopWatch;

import org.w3c.dom.ls.LSOutput;

import java.util.Date;

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
