package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderNew> {

    private static final String TAG = "com.example.recyclerview.RecyclerViewAdapter";

    private ArrayList<Country> countries;
    private Context context;

    public RecyclerViewAdapter(ArrayList<Country> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderNew onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        return new ViewHolderNew(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderNew holder, final int position) {

        Glide.with(context)
                .asBitmap()
                .load(countries.get(position).getcFlag())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView);
        holder.textView.setText(countries.get(position).getcName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, countries.get(position).getcName(), Toast.LENGTH_SHORT).show();

//                holder.textView.setText("new");


            }
        });

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    class ViewHolderNew extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        RelativeLayout parentLayout;

        public ViewHolderNew(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }


    }
}
