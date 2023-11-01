package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shahzaib.gmailresponsiveuiclone.R;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    Context context;
    SparseBooleanArray sparseBooleanArray; // for identifying: in list which items are selected
    MessageAdapterClickListener clickListener;

    public MessagesAdapter(MessageAdapterClickListener clickListener)
    {
        this.clickListener = clickListener;
        sparseBooleanArray = new SparseBooleanArray();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.single_item_messages_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        // bind data here


        holder.itemView.setSelected(sparseBooleanArray.get(position,false));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setItemStateSelected(holder.itemView, position);
                clickListener.onAdapterItemClick(position);
            }
        });


    }

    private void setItemStateSelected(View itemView, int position) {
        if(sparseBooleanArray.get(position,false))
        {
            Toast.makeText(context, "Item is Already Selected", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // deselect the previous selected item & select the clicked items
            deSelectPreviousSelectedItem();
            itemView.setSelected(true);
            sparseBooleanArray.append(position,true);
            notifyDataSetChanged();
        }
    }

    private void deSelectPreviousSelectedItem() {
        sparseBooleanArray.clear();
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView senderName, messageSubject, messagBody;
        ImageView senderImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            senderName = itemView.findViewById(R.id.sender_name);
            messageSubject = itemView.findViewById(R.id.message_subject);
            messagBody = itemView.findViewById(R.id.message_body);
            senderImage = itemView.findViewById(R.id.sender_profile_picture);
        }
    }


    public interface MessageAdapterClickListener
    {
        void onAdapterItemClick(int clickedItemPosition);
    }

}
