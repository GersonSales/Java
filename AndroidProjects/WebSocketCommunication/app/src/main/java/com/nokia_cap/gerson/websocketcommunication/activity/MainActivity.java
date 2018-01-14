package com.nokia_cap.gerson.websocketcommunication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nokia_cap.gerson.websocketcommunication.R;
import com.nokia_cap.gerson.websocketcommunication.listener.UiThreadRunnable;
import com.nokia_cap.gerson.websocketcommunication.service.WebSocket;

import org.java_websocket.exceptions.WebsocketNotConnectedException;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity implements UiThreadRunnable {

    private WebSocket mWebSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWebSocket();

        Button sendMessageButton = findViewById(R.id.sendMessageButton);
        sendMessageButton.setOnClickListener( view -> {
            sendMessage();
        });
    }

    private void setupWebSocket() {
        URI uri;
        try {
            uri = new URI("ws://192.168.130.24:8080");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        mWebSocket = new WebSocket(uri, this);
        try {
            mWebSocket.send("Connection established");
            Toast.makeText(this, "Connection established!", Toast.LENGTH_SHORT).show();
        }catch (WebsocketNotConnectedException exception) {
            exception.printStackTrace();
            Toast.makeText(this, "Connection failed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendMessage() {
        EditText editText = findViewById(R.id.message_EditText);
        try {
            mWebSocket.send(editText.getText().toString());
        }catch (WebsocketNotConnectedException exception) {
            exception.printStackTrace();
            Toast.makeText(this, "Connection failed!", Toast.LENGTH_SHORT).show();
        }
        editText.setText("");
    }

    @Override
    public void runAtUiThread(Runnable action) {
        runOnUiThread(action);
    }

    @Override
    public void sendMessage(String message) {
        TextView textView = (TextView)findViewById(R.id.receivedMessages);
        textView.setText(textView.getText() + "\n" + message);
    }
}
