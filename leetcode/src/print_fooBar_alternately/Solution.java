package print_fooBar_alternately;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class FooBar {
    private int n;

    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sem1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            sem2.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sem2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            sem1.release();

        }
    }


    public static void main(String[] args) {
        var foobar = new FooBar(5);

        new Thread(() -> {
            try {
                foobar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foobar.bar(() -> System.out.print("bar\n"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
