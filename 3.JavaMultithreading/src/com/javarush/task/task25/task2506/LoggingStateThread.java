package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread th;

    public LoggingStateThread(Thread target) {
        this.th = target;
    }

    @Override
    public void run() {
        super.run();
        State currentState, previousState = null;
        while (th.getState() != State.TERMINATED) {
            currentState = th.getState();
            if (currentState != previousState) {
                System.out.println(currentState);
                previousState = currentState;
            }
        }
        this.interrupt();
    }
}
