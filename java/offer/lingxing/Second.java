package offer.lingxing;

/**
 * @Description TODO
 * @Author 爱做梦的鱼
 * @Blog https://zihao.blog.csdn.net/
 * @Date 2023/4/24 21:43
 */
public class Second {

  public static class PrintRunnable implements Runnable {

    private final Object lock;

    public PrintRunnable(Object lock) {
      this.lock = lock;
    }

    /**
     * When an object implementing interface {@code Runnable} is used to create a thread, starting
     * the thread causes the object's {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
      synchronized (lock) {
        for (int i = 0; i < 3; i++) {
          if (Thread.currentThread().getName().equals("print ABC")) {
            System.out.println("ABC".charAt(i));
            lock.notify();
            try {
              lock.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          } else {
            System.out.println("123".charAt(i));
            lock.notify();
            try {
              lock.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Object lock = new Object();
    Thread thread = new Thread(new PrintRunnable(lock), "print 123");
    Thread thread1 = new Thread(new PrintRunnable(lock), "print ABC");
    thread.start();
    thread1.start();
  }
}
