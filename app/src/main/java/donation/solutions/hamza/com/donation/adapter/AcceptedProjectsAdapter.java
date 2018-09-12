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
import donation.solutions.hamza.com.donation.model.AcceptedProjects;


public class AcceptedProjectsAdapter extends RecyclerView.Adapter<AcceptedProjectsAdapter.VH> {

    private int rowLayout;
    private Context context;
    private ArrayList<AcceptedProjects> acceptedProjects;
    private onProjectClickListner onProjectClickListner;


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

    public AcceptedProjectsAdapter(int rowLayout, ArrayList<AcceptedProjects> acceptedDonations, Context context, onProjectClickListner listner) {

        this.rowLayout = rowLayout;
        this.context = context;
        this.acceptedProjects = acceptedDonations;
        this.onProjectClickListner = listner;

    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {

        if (acceptedProjects.get(position).getImg().size() != 0) {
            Glide.with(context).load(acceptedProjects.get(position).getImg().get(0)).into(holder.donateHIstoryIV);
        }
        holder.donateDateTV.setText(acceptedProjects.get(position).getCreationDate().subSequence(0,10));
        holder.DonateDescriptionTV.setText(acceptedProjects.get(position).getDesc());
        holder.donateHistoryTitleTV.setText(acceptedProjects.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProjectClickListner.onProjectClickListner(acceptedProjects.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return acceptedProjects.size();
    }

    public interface onProjectClickListner {
        void onProjectClickListner(AcceptedProjects project);

    }


}

