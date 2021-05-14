public class Storage extends Thread {
    public int isalive;
    public Details a;
    public int time = 1;

    public Storage() {
    }

    public Storage(Details s, int time) {
        this.a = s;
        if (time > 0) {
            this.time = time;
        }

    }

    public void run() {
        try {
            a.isalive = false;
            Thread.sleep(1000 * time);
            a.isalive = true;
        } catch (Exception s) {
            System.out.println("Some error in the Thread");
        }
    }
}
