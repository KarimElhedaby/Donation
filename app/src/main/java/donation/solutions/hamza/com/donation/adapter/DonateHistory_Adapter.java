package donation.solutions.hamza.com.donation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.model.HistoryOfDonation;


public class DonateHistory_Adapter extends RecyclerView.Adapter<DonateHistory_Adapter.VH> {

    private int rowLayout;
    private Context context;
    private ArrayList<HistoryOfDonation> donations;


    public static class VH extends RecyclerView.ViewHolder {

        ImageView donateHIstoryIV;
        TextView donateHistoryTitleTV;
        TextView donateDateTV;
        TextView DonateDescriptionTV;


        public VH(View v) {
            super(v);
            donateHIstoryIV = v.findViewById(R.id.donateHIstory_IV);
            donateHistoryTitleTV = v.findViewById(R.id.donateHistoryTitleTV);
            donateDateTV = v.findViewById(R.id.donateDateTV);
            DonateDescriptionTV = v.findViewById(R.id.DonateDescriptionTV);

        }
    }

    public DonateHistory_Adapter(int rowLayout, ArrayList<HistoryOfDonation> donationsHistory, Context context) {

        this.rowLayout = rowLayout;
        this.context = context;
        this.donations = donationsHistory;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {

        if (donations.get(position).getImg().size() != 0) {
            Glide.with(context).load(donations.get(position).getImg().get(0)).into(holder.donateHIstoryIV);
        }
        holder.donateDateTV.setText(donations.get(position).getCreationDate().subSequence(0,10));
        holder.DonateDescriptionTV.setText(donations.get(position).getDesc());
        holder.donateHistoryTitleTV.setText(donations.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return donations.size();
    }


}

