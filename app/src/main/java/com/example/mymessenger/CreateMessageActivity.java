package com.example.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CreateMessageActivity extends Activity {

    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_SENDER = "sender";
    private List<Message> messageList = new ArrayList<>();
    private String currentUser = "Propietario"; // Cambia a "Cuidador" después de enviar un mensaje

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        // Mostrar historial de mensajes
        displayMessageHistory();
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        // Agregar el mensaje a la lista
        messageList.add(new Message(messageText, currentUser));

        // Cambiar de usuario
        currentUser = currentUser.equals("Propietario") ? "Cuidador" : "Propietario";

        // Limpiar el campo de texto
        messageView.setText("");

        // Mostrar historial de mensajes
        displayMessageHistory();

        // Enviar el mensaje a la otra actividad
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, messageText);
        intent.putExtra(EXTRA_SENDER, currentUser);
        startActivity(intent);
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