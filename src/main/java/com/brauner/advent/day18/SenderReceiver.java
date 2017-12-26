package com.brauner.advent.day18;

import java.util.LinkedList;
import java.util.Objects;

public class SenderReceiver {

    LinkedList<Long> list = new LinkedList<>();


    protected long receive() {
        synchronized (this)
        {
            while (list.size()==0)
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            //to retrive the ifrst job in the list
            return list.removeFirst();

        }
    }

    protected void send(long value) {
        synchronized (this)
        {
            // producer thread waits while list
            // is full

            // to insert the jobs in the list
            list.add(value);

            // notifies the consumer thread that
            // now it can start consuming
            // makes the working of program easier
            // to  understand

            notify();
        }
    }
}
