package com.example.shahzaib.gmailresponsiveuiclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragments.MessageDetailFragment;

public class Detailed_Message extends AppCompatActivity {


    MessageDetailFragment messageDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed__message);
        messageDetailFragment = (MessageDetailFragment) getSupportFragmentManager().findFragmentById(R.id.messages_detail_fragment);
        messageDetailFragment.setDisplayHomeEnable();
    }
}
