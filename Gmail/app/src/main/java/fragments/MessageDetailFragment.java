package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shahzaib.gmailresponsiveuiclone.R;

public class MessageDetailFragment extends Fragment {

    Toolbar toolbar;
    AppCompatActivity appCompatActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_detail_fragment_layout,container,false);
        toolbar = view.findViewById(R.id.messagesDetailToolbar);
        appCompatActivity = (AppCompatActivity) getActivity();

        // initial setup
        setupToolbar();
        setHasOptionsMenu(true);

        return view;
    }

    /** Helper Methods*/
    private void setupToolbar() {
        if(appCompatActivity !=null)
        {
            toolbar.inflateMenu(R.menu.message_detail_toolbar_menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(appCompatActivity, item.getTitle()+ " Clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else
        {
            SHOW_LOG("App compact activity is null");
        }
    }

    private void SHOW_LOG(String message) {
        Log.i("123456",message);
    }

    public void setDisplayHomeEnable()
    {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_arrow));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                appCompatActivity.onBackPressed();
            }
        });
    }

}
