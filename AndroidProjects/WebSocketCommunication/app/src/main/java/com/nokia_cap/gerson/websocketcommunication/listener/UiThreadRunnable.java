package com.nokia_cap.gerson.websocketcommunication.listener;

/**
 * Created by GersonSales on 1/10/2018.
 */

public interface UiThreadRunnable {

    void runAtUiThread(Runnable action);

    void sendMessage(String message);
}
