package donation.solutions.hamza.com.donation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DonateDetails_Adapter extends RecyclerView.Adapter<DonateDetails_Adapter.VH> {

    private int rowLayout;
    private Context context;

//    private On_allCommunity_ClickListener on_allCommunity_clickListener;

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

    public DonateDetails_Adapter(int rowLayout, Context context) {

        this.rowLayout = rowLayout;
        this.context = context;
//
//        if (context instanceof On_allCommunity_ClickListener) {
//            on_allCommunity_clickListener = (On_allCommunity_ClickListener) context;
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
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                on_allCommunity_clickListener.on_allCommunity_Click(dataList.get(position));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 10 ;
    }

//    public interface On_allCommunity_ClickListener {
//        void on_allCommunity_Click(Community community);
//
//    }
}

