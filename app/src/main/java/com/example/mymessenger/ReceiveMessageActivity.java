package com.example.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReceiveMessageActivity extends Activity {

    private List<Message> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        // Recibir el mensaje y el remitente
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(CreateMessageActivity.EXTRA_MESSAGE);
        String sender = intent.getStringExtra(CreateMessageActivity.EXTRA_SENDER);

        // Agregar el mensaje a la lista
        if (messageText != null && sender != null) {
            messageList.add(new Message(messageText, sender));
        }

        // Mostrar historial de mensajes
        displayMessageHistory();
    }

    private void displayMessageHistory() {
        TextView historyView = (TextView) findViewById(R.id.history);
        StringBuilder historyText = new StringBuilder();

        for (Message message : messageList) {
            historyText.append(message.getSender()).append(": ").append(message.getText()).append("\n");
        }

        historyView.setText(historyText.toString());
    }
}

