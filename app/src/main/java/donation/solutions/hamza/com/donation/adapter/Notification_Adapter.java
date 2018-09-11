package donation.solutions.hamza.com.donation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.model.NotificationResponce;


public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.VH> {

    private int rowLayout;
    private Context context;
    private ArrayList<NotificationResponce> notificationResponces;


    public static class VH extends RecyclerView.ViewHolder {


        TextView notificationTV;
        TextView notificationDateTV;
//        ImageView my_communityIV;

        public VH(View v) {
            super(v);
            notificationTV = (TextView) v.findViewById(R.id.notificationTV);
            notificationDateTV = (TextView) v.findViewById(R.id.notificationDateTV);

        }
    }

    public Notification_Adapter(int rowLayout, ArrayList<NotificationResponce> notificationResponces, Context context) {
        this.rowLayout = rowLayout;
        this.notificationResponces = notificationResponces;
        this.context = context;

    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        holder.notificationTV.setText(notificationResponces.get(position).getText());
        holder.notificationDateTV.setText(notificationResponces.get(position).getCreationDate().subSequence(0,10));

    }

    @Override
    public int getItemCount() {
        return notificationResponces.size();
    }


}

