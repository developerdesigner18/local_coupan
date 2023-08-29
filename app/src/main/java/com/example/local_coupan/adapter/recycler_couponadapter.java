package com.example.local_coupan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.local_coupan.R;
import com.example.local_coupan.model.get_coupon_data.CouponDatum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class recycler_couponadapter extends RecyclerView.Adapter<recycler_couponadapter.viewholder> implements Filterable {

    OnItemClickListener mlisner;
    List<CouponDatum> list;
    List<CouponDatum> search_list;

    public void setOnItemClicklistner(OnItemClickListener listener) {
        mlisner = listener;
    }

    public recycler_couponadapter(List<CouponDatum> list) {
        this.list = list;
        search_list = new ArrayList<>(list);
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {

            List<CouponDatum> filteredata = new ArrayList<>();

            if (keyword.toString().isEmpty()) {
                filteredata.addAll(search_list);
            } else {
                //String filterPattern = keyword.toString().toLowerCase().trim();

                for (CouponDatum obj : search_list) {
                    if (obj.getCouponTitle().toLowerCase().contains(keyword.toString().toLowerCase())) {
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
            list.clear();

            //     list.addAll((List) results.values);
            //    Log.d("TAG", "publishResults: devi1 1");

            //list.addAll((ArrayList<Datum>) results.values);
//            Log.d("TAG", "publishResults: devi1 2");

            list.addAll((Collection<CouponDatum>) results.values);
            Log.d("TAG", "publishResults: devi1 3");

            notifyDataSetChanged();
        }
    };

    public interface OnItemClickListener {

        void onbudgetclick(int position);

        void ondeliveries(int position);

        void scanned(int position);

        void onrunclick(int posision);

        void onpreviewclick(int posision);

        void oneditlick(int posision);

        void onshareclick(int position);

    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_coupon_adapter, parent, false);

        viewholder myviewholder = new viewholder(view, (OnItemClickListener) mlisner);
        return myviewholder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        holder.txt_coupon_title.setText(list.get(position).getCouponTitle());

        Boolean status = list.get(position).getPlayPauseStatus();

        Log.d("PlayPauseStatus123", "onBindViewHolder: " + status);
        Log.d("PlayPauseStatus123", "onBindViewHolder: " + list.get(position).getId());

        if (list.get(position).getPlayPauseStatus().equals(true)) {

            holder.txt_coupon_live.setText("LIVE");
//            holder.txt_play.setText("Pause");
            holder.btn_run.setVisibility(View.VISIBLE);
            holder.btn_play.setVisibility(View.GONE);
            holder.txt_coupon_live.setTextColor(Color.parseColor("#00BABA"));

        } else if (list.get(position).getPlayPauseStatus().equals(false)) {

//            holder.txt_play.setText("Play");
            holder.txt_coupon_live.setText("PAUSED");
            holder.btn_run.setVisibility(View.GONE);
            holder.btn_play.setVisibility(View.VISIBLE);
            holder.txt_coupon_live.setTextColor(Color.parseColor("#EB4949"));

        }
        if (list.get(position).getOtherShared()) {
            holder.btn_share.setVisibility(View.GONE);
            holder.btn_from_share.setVisibility(View.VISIBLE);

        } else {
            holder.btn_share.setVisibility(View.VISIBLE);
            holder.btn_from_share.setVisibility(View.GONE);
        }

//        Toast.makeText(context, "" + list.get(position).getStatistics().get(0).getRemainingBudget().toString(), Toast.LENGTH_SHORT).show();

//        Log.d("data_remaining", "onBindViewHolder: " + list.get(position).getStatistics().get(0).getRemainingBudget().toString());


        holder.txt_user_name.setText(list.get(position).getShareCoupon());

        if (list.get(position).getShareCoupon() == null || list.get(position).getShareCoupon().isEmpty()) {

            Log.d("letter123", "onBindViewHolder: " + "letter");
        } else {
//            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            holder.name_letter1.setText(String.valueOf(list.get(position).getShareCoupon().charAt(0)).toUpperCase(Locale.ROOT));
        }

        if (list.get(position).getStatistics().get(0).getRemainingBudget() == null) {
            holder.txt_price.setText("0");
        } else {
            holder.txt_price.setText(list.get(position).getStatistics().get(0).getRemainingBudget().toString());
        }

        if (list.get(position).getStatistics().get(0).getDeliveries() == null) {
            holder.txt_deliveries_price.setText("0");
        } else {
            holder.txt_deliveries_price.setText(list.get(position).getStatistics().get(0).getDeliveries().toString());
        }

        if (list.get(position).getScanned_Redemptions() == null) {
            holder.txt_scanned_number.setText("0");
        } else {
            holder.txt_scanned_number.setText(list.get(position).getScanned_Redemptions().toString());
        }

        boolean share = list.get(position).getShared();
        if (share) {

            holder.btn_share.setVisibility(View.VISIBLE);

        } else {

            holder.btn_share.setVisibility(View.GONE);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    Context context;

    public static class viewholder extends RecyclerView.ViewHolder {

        TextView txt_coupon_title, txt_coupon_live, txt_budget, txt_price, txt_deliveries,
                txt_deliveries_price, txt_scanned_redemption, txt_scanned_number, txt_play, txt_user_name, name_letter1;
        CardView btn_run, btn_preview, btn_edit, btn_share, img_coupon_image, btn_play, btn_play_pause;
        LinearLayout llout1, llout2, llout3, btn_from_share;

        @SuppressLint("SetTextI18n")
        public viewholder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            txt_coupon_title = itemView.findViewById(R.id.txt_coupon_title);
            txt_coupon_live = itemView.findViewById(R.id.txt_coupon_live);
            txt_budget = itemView.findViewById(R.id.txt_budget);
            txt_price = itemView.findViewById(R.id.txt_price);
            txt_deliveries = itemView.findViewById(R.id.txt_deliveries);
            txt_deliveries_price = itemView.findViewById(R.id.txt_deliveries_price);
            txt_scanned_redemption = itemView.findViewById(R.id.txt_scanned_redemption);
            txt_scanned_number = itemView.findViewById(R.id.txt_scanned_number);
            txt_play = itemView.findViewById(R.id.txt_play);

            btn_run = itemView.findViewById(R.id.btn_run);
            btn_play = itemView.findViewById(R.id.btn_play);
            btn_play_pause = itemView.findViewById(R.id.btn_play_pause);
            btn_preview = itemView.findViewById(R.id.btn_preview);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            btn_share = itemView.findViewById(R.id.btn_main_share);
            btn_from_share = itemView.findViewById(R.id.btn_from_share);

            llout1 = itemView.findViewById(R.id.llout1);
            llout2 = itemView.findViewById(R.id.llout2);
            llout3 = itemView.findViewById(R.id.llout3);

            txt_user_name = itemView.findViewById(R.id.txt_user_name);
            name_letter1 = itemView.findViewById(R.id.name_letter);
            img_coupon_image = itemView.findViewById(R.id.img_coupon_image);

            btn_play_pause.setOnClickListener(v -> {

                if (listener != null) {
                    int position1 = getAdapterPosition();
                    if (position1 != RecyclerView.NO_POSITION) {
                        listener.onrunclick(position1);

                        Log.d("viru1", "viewholder: " + txt_coupon_live.getText().toString());
//
//                        if (txt_coupon_live.getText().toString().equals("LIVE")) {
//
//                            Log.d("viru2", "viewholder: 2");
//                            txt_coupon_live.setText("PAUSED");
//                            txt_coupon_live.setTextColor(Color.parseColor("#EB4949"));
//
////                            btn_play.setVisibility(View.VISIBLE);
////                            btn_run.setVisibility(View.GONE);
//
//                        } else if (txt_coupon_live.getText().toString().equals("PAUSED")) {
//                            Log.d("viru2", "viewholder: 3");
//                            txt_coupon_live.setText("LIVE");
//                            txt_coupon_live.setTextColor(Color.parseColor("#00BABA"));
////                                      btn_play.setVisibility(View.GONE);
////                            btn_run.setVisibility(View.VISIBLE);
//                        }
                    }
                }
            });

            btn_share.setOnClickListener(v -> {
                if (listener != null) {
                    int position1 = getAdapterPosition();
                    if (position1 != RecyclerView.NO_POSITION) {
                        listener.onshareclick(position1);
                    }
                }
            });

            btn_preview.setOnClickListener(v -> {
                if (listener != null) {
                    int position1 = getAdapterPosition();
                    if (position1 != RecyclerView.NO_POSITION) {
                        listener.onpreviewclick(position1);
                    }
                }
            });
            btn_edit.setOnClickListener(v -> {
                if (listener != null) {
                    int position1 = getAdapterPosition();
                    if (position1 != RecyclerView.NO_POSITION) {
                        listener.oneditlick(position1);
                    }
                }
            });

            llout1.setOnClickListener(v -> {
                if (listener != null) {
                    int position1 = getAdapterPosition();
                    if (position1 != RecyclerView.NO_POSITION) {
                        listener.onbudgetclick(position1);
                    }
                }
            });

            llout2.setOnClickListener(v -> {
                if (listener != null) {
                    int position1 = getAdapterPosition();
                    if (position1 != RecyclerView.NO_POSITION) {
                        listener.ondeliveries(position1);
                    }
                }
            });

            llout3.setOnClickListener(v -> {
                if (listener != null) {
                    int position1 = getAdapterPosition();
                    if (position1 != RecyclerView.NO_POSITION) {
                        listener.scanned(position1);
                    }
                }
            });
        }
    }
}