package com.example.local_coupan.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.local_coupan.model.userlist_model.Userlist_data;

import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.local_coupan.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class share_recycle_adapter extends RecyclerView.Adapter<share_recycle_adapter.ViewHolder> implements Filterable {

    OnItemClickListener mlisner2;
    Context context;
    List<Userlist_data> arradapterchat;
    List<Userlist_data> share_name;

    public share_recycle_adapter(Context context, List<Userlist_data> arradapterchat) {
        this.context = context;
        this.arradapterchat = arradapterchat;
        share_name = new ArrayList<>(arradapterchat);
        setHasStableIds(true);

    }

    public void setOnItemClicklistner(OnItemClickListener lisner) {
        mlisner2 = lisner;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {

            List<Userlist_data> filteredata = new ArrayList<>();

            if (keyword.toString().isEmpty()) {
                filteredata.addAll(share_name);
            } else {
                //String filterPattern = keyword.toString().toLowerCase().trim();

                for (Userlist_data obj : share_name) {
                    if (obj.getName().toLowerCase().contains(keyword.toString().toLowerCase())) {
                        Log.d("TAG123", "performFiltering: devi1 if");
                        filteredata.add(obj);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredata;
            return results;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arradapterchat.clear();

            arradapterchat.addAll((Collection<Userlist_data>) results.values);
            Log.d("TAG", "publishResults: devi1 3");

            notifyDataSetChanged();

        }
    };

    public interface OnItemClickListener {

        void oncheck_click(int position);

        void on_next_click(int position);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_direct_message, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, (OnItemClickListener) mlisner2);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(260), rnd.nextInt(200), rnd.nextInt(250));
        holder.cardView.setBackgroundTintList(ColorStateList.valueOf(currentColor));

        holder.txt_get_username.setText(arradapterchat.get(position).getName());
        String first_name = String.valueOf(arradapterchat.get(position).getName().charAt(0));
        holder.txt_firstname.setText(first_name.toUpperCase(Locale.ROOT));

        SharedPreferences sh = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String share_userid = sh.getString("share_userids", "");
        String share_id = arradapterchat.get(position).getId();
        String name = arradapterchat.get(position).getName();

        Log.d("share_userid132", "onBindViewHolder: " + "share_userid" +" "+ share_userid);
        Log.d("share_userid132", "onBindViewHolder: " + "share_userid" +" "+ share_id);
        Log.d("share_userid132", "onBindViewHolder: " + "share_userid" +" "+ name);

        if (share_userid.contains(share_id)){

            Log.d("share_id111", "onBindViewHolder: " + share_id);
            String final_share = share_id;

            holder.checked.setChecked(true);
            holder.img_next.setVisibility(View.VISIBLE);

        }else{

        }
    }

    @Override
    public int getItemCount() {
        return arradapterchat.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        SwitchCompat checked;
        TextView txt_get_username, txt_firstname;
        CardView cardView;
        LinearLayout img_next;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener mlistener2) {

            super(itemView);
            cardView = itemView.findViewById(R.id.img_share_message);
            checked = itemView.findViewById(R.id.checkBox);
            txt_get_username = itemView.findViewById(R.id.txt_direct_share_message);
            txt_firstname = itemView.findViewById(R.id.firstname);
            img_next = itemView.findViewById(R.id.next);

            checked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mlistener2.oncheck_click(getAbsoluteAdapterPosition());
                    Log.d("getAdapterPosition", "onClick: " + getAbsoluteAdapterPosition());

                    if (checked.isChecked()) {
                        img_next.setVisibility(View.VISIBLE);

                    } else if (!checked.isChecked()) {
                        img_next.setVisibility(View.INVISIBLE);
                    }
                }
            });

            img_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mlistener2.on_next_click(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}