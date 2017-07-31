package me.anjas.educationvee.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.anjas.educationvee.R;
import me.anjas.educationvee.objects.Jobsheet;

/**
 * Created by anjas on 30/07/17.
 */

public class JobsheetAdapter extends RecyclerView.Adapter<JobsheetViewHolder> {
    private Context context;
    private ArrayList<Jobsheet> itemList;

    public JobsheetAdapter(Context context, ArrayList<Jobsheet> itemList) {
        super();
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public JobsheetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jobsheet, null);
        JobsheetViewHolder view = new JobsheetViewHolder(layoutView);
        return view;
    }

    @Override
    public void onBindViewHolder(JobsheetViewHolder holder, int position) {
        holder.titleView.setText(itemList.get(position).getTitle());
        holder.descriptionView.setText(itemList.get(position).getDescription());
        switch (itemList.get(position).getStatus()){
            case 0:
                holder.statusImage.setImageResource(R.drawable.gray_circle);
                break;
            case 1:
                holder.statusImage.setImageResource(R.drawable.blue_circle);
                break;
            case 2:
                holder.statusImage.setImageResource(R.drawable.green_circle);
                break;
            default:
                holder.statusImage.setImageResource(R.drawable.gray_circle);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
