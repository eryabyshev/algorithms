package print_in_order;

import java.util.concurrent.Semaphore;

public class Foo {

    private Semaphore run2 = new Semaphore(0);
    private Semaphore run3 = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}


