package donation.solutions.hamza.com.donation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.VH> {

    private int rowLayout;
    private Context context;


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

    public Notification_Adapter(int rowLayout, Context context) {

        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return 10;
    }


}

