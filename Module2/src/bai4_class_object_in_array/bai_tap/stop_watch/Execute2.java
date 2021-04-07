package bai4_class_object_in_array.bai_tap.stop_watch;

public class Execute2 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("hello world");
        }
        stopWatch.stop();
        long time = stopWatch.getElapsedTime();
        System.out.println("Thời gian thực hiện vòng lặp : " + time);
        System.out.println(stopWatch.getStartTime());
    }
}
