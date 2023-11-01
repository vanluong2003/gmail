package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shahzaib.gmailresponsiveuiclone.R;

import adapter.MessagesAdapter;

public class MessagesListFragment  extends Fragment implements MessagesAdapter.MessageAdapterClickListener {

    RecyclerView messagesRecyclerView;
    MessagesAdapter adapter;
    Toolbar toolbar;
    OnMessagesClickListener clickListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.messages_list_fragment_layout,container,false);

        // initialization
        messagesRecyclerView = view.findViewById(R.id.messages_recyclerView);
        adapter = new MessagesAdapter(this);
        toolbar = view.findViewById(R.id.toolbar);



        // initial setup
        setupToolbar();
        setHasOptionsMenu(true);
        setupRecyclerView();
        messagesRecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.messages_list_toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_item_search:
                Toast.makeText(getContext(), "Search Icon Clicked", Toast.LENGTH_SHORT).show();
                return true;
        }

        return false;
    }


    @Override
    public void onAdapterItemClick(int clickedItemPosition) {
        SHOW_LOG("clicked item position: "+clickedItemPosition);
        if(clickListener!=null) clickListener.onMessageClick(clickedItemPosition);

    }











    /** Helper Methods*/
    private void SHOW_LOG(String message) {
        Log.i("123456",message);
    }

    private void setupToolbar()
    {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Inbox");


    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        messagesRecyclerView.setLayoutManager(linearLayoutManager);
        messagesRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),linearLayoutManager.getOrientation()));
    }
    public void setClickListener(OnMessagesClickListener clickListener)
    {
        this.clickListener = clickListener;
    }



    public interface OnMessagesClickListener{
        void onMessageClick(int clickedMessagePosition);
    }

}
