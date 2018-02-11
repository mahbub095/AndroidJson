package com.owntaks.mahbub.androidjason.adapter;

/**
 * Created by Juned on 2/6/2017.
 */

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.owntaks.mahbub.androidjason.helperclick.ItemClickListener;
import com.owntaks.mahbub.androidjason.R;
import com.owntaks.mahbub.androidjason.activity.DetailActivity;
import com.owntaks.mahbub.androidjason.model.DataAdapter;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    Context context;

    List<DataAdapter> dataAdapters;

    public RecyclerViewAdapter(List<DataAdapter> getDataAdapter, Context context) {

        super();

        this.dataAdapters = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final String name = dataAdapters.get(position).getName();
        final String age = dataAdapters.get(position).getAge();
        final String blgroup = dataAdapters.get(position).getBlgroup();
        final String mnum = dataAdapters.get(position).getMnum();
        final String loc = dataAdapters.get(position).getLoc();
        final String lbdd = dataAdapters.get(position).getIbdd();

        viewHolder.TextViewName.setText(name);
        viewHolder.Age.setText(age);
        viewHolder.Blgroup.setText(blgroup);
        viewHolder.Mnum.setText(mnum);
        viewHolder.Loc.setText(loc);
        viewHolder.LastBloodDonatedate.setText(lbdd);


        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name, age, blgroup,mnum,loc,lbdd);
                Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return dataAdapters.size();
    }


    private void openDetailActivity(String name, String age, String blgroup, String mnum,String loc,String ibdd) {
        Intent i = new Intent(context, DetailActivity.class);

        //PACK DATA TO SEND
        i.putExtra("NAME_KEY", name);
        i.putExtra("AGE", age);
        i.putExtra("BLGROUP", blgroup);
        i.putExtra("MNUM", mnum);
        i.putExtra("LOC", loc);
        i.putExtra("IBDD", ibdd);


        //open activity
        context.startActivity(i);

    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView TextViewName;
        public TextView Age;
        public TextView Blgroup;
        public TextView Mnum;
        public TextView Loc;
        public TextView LastBloodDonatedate;


        ItemClickListener itemClickListener;


        public ViewHolder(View itemView) {

            super(itemView);

            TextViewName = (TextView) itemView.findViewById(R.id.textView4);
            Age = (TextView) itemView.findViewById(R.id.textView6);
            Blgroup = (TextView) itemView.findViewById(R.id.textView8);
            Mnum = (TextView) itemView.findViewById(R.id.textView10);
            Loc = (TextView) itemView.findViewById(R.id.textView12);
            LastBloodDonatedate = (TextView) itemView.findViewById(R.id.textView14);
            itemView.setOnClickListener((View.OnClickListener) this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }
    }
}