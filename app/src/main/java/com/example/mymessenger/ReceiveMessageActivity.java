package com.example.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();
        String messageText = intent.getStringExtra(CreateMessageActivity.EXTRA_MESSAGE);

        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(messageText);
    }
}
