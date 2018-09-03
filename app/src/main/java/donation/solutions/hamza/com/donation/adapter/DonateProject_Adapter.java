package donation.solutions.hamza.com.donation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class DonateProject_Adapter extends RecyclerView.Adapter<DonateProject_Adapter.VH> {

    private int rowLayout;
    private Context context;

    private onProjectClickListner onProjectClickListner;

    public static class VH extends RecyclerView.ViewHolder {


//        TextView my_communityDescriptionTV;
//        TextView my_communitynameTV;
//        ImageView my_communityIV;

        public VH(View v) {
            super(v);
//            my_communityDescriptionTV = (TextView) v.findViewById(R.id.my_communityDescriptionTV);
//            my_communitynameTV = (TextView) v.findViewById(R.id.my_CommunityTitleTV);
//            my_communityIV = (ImageView) v.findViewById(R.id.mycommunity_IV);

        }
    }

    public DonateProject_Adapter( int rowLayout, Context context , onProjectClickListner listner) {

        this.rowLayout = rowLayout;
        this.context = context;
        this.onProjectClickListner =listner ;

//
//        if (context instanceof On_allCommunity_ClickListener) {
//            onProjectClickListner = (onProjectClickListner) context;
//        } else {
//            throw new RuntimeException("Context must implement On_AllCommunity_ClickListener");
//        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {

//        holder.my_communityDescriptionTV.setText(String.valueOf(dataList.get(position).getCommunity_description()));
//        holder.my_communitynameTV.setText(String.valueOf(dataList.get(position).getCommunity_name()));
//        Glide.with(context).load(dataList.get(position).getCommunity_picture()).
//                into(holder.my_communityIV);
//
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProjectClickListner.onProjectClickListner();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10 ;
    }

    public interface onProjectClickListner {
        void onProjectClickListner();

    }
}

