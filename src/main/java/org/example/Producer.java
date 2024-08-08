package org.example;

import java.util.Random;

class Producer implements Runnable {
    private SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int number = random.nextInt(100);
                sharedBuffer.add(number);
                System.out.println("Produced: " + number);
                Thread.sleep(100); // Simulate time taken to produce a number
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
