package com.nokia_cap.gerson.websocketcommunication.service;

import android.os.Build;
import android.util.Log;
import android.widget.TextView;

import com.nokia_cap.gerson.websocketcommunication.R;
import com.nokia_cap.gerson.websocketcommunication.listener.UiThreadRunnable;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * Created by GersonSales on 1/10/2018.
 */

public class WebSocket extends WebSocketClient{
    private UiThreadRunnable mRunnable;

    public WebSocket(URI serverURI, UiThreadRunnable runnable) {
        super(serverURI);
        mRunnable = runnable;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Log.i("Websocket", "Opened");
        send("Hello from " + Build.MANUFACTURER + " " + Build.MODEL);
    }

    @Override
    public void onMessage(String message) {
        mRunnable.runAtUiThread(() -> mRunnable.sendMessage(message));
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.i("Websocket", "Closed " + reason);
    }

    @Override
    public void onError(Exception exception) {
        Log.i("Websocket", "Error " + exception.getMessage());

    }
}
