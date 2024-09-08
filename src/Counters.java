public class Counters {

    // Thread counting up from to 20
    static class IncreaseThread extends Thread {

        // Override run() method to specify what will run in first thread
        @Override
        public void run() {
            System.out.println("\nCounting up from 0: ");

            // loop incrementing from 0 to 20
            for (int i = 0; i <= 20; i++) {
                System.out.println(i);
            }
        }
    }

    // Thread counting down from 20 to 0
    static class DecreaseThread extends Thread {

        // Override run() method to specify what will run in second thread
        @Override
        public void run() {
            System.out.println("\nCounting down from 20: ");

            //loop decreasing by 1 from 20 to 0
            for (int i = 20; i >= 0; i--) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {

        // create the increaseThread
        IncreaseThread increaseThread = new IncreaseThread();

        // Start the increaseThread
        increaseThread.start();


        try {

            // increaseThread will run, then after it completes the decreaseThread can run to prevent concurrency
            increaseThread.join();

            // Throw interruptedexception
        } catch (InterruptedException e) {
            if (Thread.currentThread().isInterrupted()) {

                // user-friendly error message to console if increaseThread is interrupted because there are only 2 threads
                System.out.println("Error: Both threads running at the same time.");
            }
            e.printStackTrace();
        }

        // create, then start the decreaseThread
        DecreaseThread decreaseThread = new DecreaseThread();
        decreaseThread.start();

    }

}
