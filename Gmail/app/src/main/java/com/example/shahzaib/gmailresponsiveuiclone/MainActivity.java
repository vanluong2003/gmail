package com.example.shahzaib.gmailresponsiveuiclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fragments.MessageDetailFragment;
import fragments.MessagesListFragment;

public class MainActivity extends AppCompatActivity  implements MessagesListFragment.OnMessagesClickListener{

    MessagesListFragment messagesListFragment;
    MessageDetailFragment messageDetailFragment;
    boolean isSinglePaneDisplay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesListFragment = (MessagesListFragment) getSupportFragmentManager().findFragmentById(R.id.messages_list_fragment);
        messageDetailFragment = (MessageDetailFragment) getSupportFragmentManager().findFragmentById(R.id.messages_detail_fragment);

        if(messageDetailFragment == null) isSinglePaneDisplay = true;
        messagesListFragment.setClickListener(this);

    }

    @Override
    public void onMessageClick(int clickedMessagePosition) {
        Toast.makeText(this, clickedMessagePosition+" Message Clicked", Toast.LENGTH_SHORT).show();
        openDetailedMessage(clickedMessagePosition);
    }

    private void openDetailedMessage(int messageID) {
        if(isSinglePaneDisplay) {
            startActivity(new Intent(this,Detailed_Message.class));
        }
        else
        {
            // change data of Detailed fragment
        }
    }
}
