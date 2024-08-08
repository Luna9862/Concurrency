package org.example;

class Consumer implements Runnable {
    private SharedBuffer sharedBuffer;
    private int sum = 0;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = sharedBuffer.remove();
                sum += number;
                System.out.println("Consumed: " + number + " | Current Sum: " + sum);
                Thread.sleep(150); // Simulate time taken to consume a number
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
