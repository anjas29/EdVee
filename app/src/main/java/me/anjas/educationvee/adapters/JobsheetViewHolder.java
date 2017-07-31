package me.anjas.educationvee.adapters;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.anjas.educationvee.DetailJobsheetActivity;
import me.anjas.educationvee.JobsheetActivity;
import me.anjas.educationvee.R;
import me.anjas.educationvee.objects.Jobsheet;

/**
 * Created by anjas on 30/07/17.
 */

public class JobsheetViewHolder extends RecyclerView.ViewHolder {
    public ImageView statusImage;
    public TextView titleView;
    public TextView descriptionView;

    public JobsheetViewHolder(final View itemView) {
        super(itemView);
        titleView = (TextView) itemView.findViewById(R.id.titleView);
        descriptionView = (TextView) itemView.findViewById(R.id.descriptionView);
        statusImage = (ImageView) itemView.findViewById(R.id.statusImage);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), DetailJobsheetActivity.class);
                intent.putExtra("title", JobsheetActivity.items.get(getAdapterPosition()).getTitle());
                intent.putExtra("status", JobsheetActivity.items.get(getAdapterPosition()).getStatus());
                intent.putExtra("description", JobsheetActivity.items.get(getAdapterPosition()).getDescription());
                intent.putExtra("kompetensi", JobsheetActivity.items.get(getAdapterPosition()).getKompetensi());
                intent.putExtra("subkompetensi", JobsheetActivity.items.get(getAdapterPosition()).getSubKompetensi());
                intent.putExtra("landasanteori", JobsheetActivity.items.get(getAdapterPosition()).getLandasanTeori());
                intent.putExtra("alatbahan", JobsheetActivity.items.get(getAdapterPosition()).getAlatBahan());
                intent.putExtra("keselamatankerja", JobsheetActivity.items.get(getAdapterPosition()).getKeselematanKerja());
                intent.putExtra("langkahkerja", JobsheetActivity.items.get(getAdapterPosition()).getLangkahPercobaan());
                intent.putExtra("latihan", JobsheetActivity.items.get(getAdapterPosition()).getLatihan());
                intent.putExtra("gambar", JobsheetActivity.items.get(getAdapterPosition()).getGambar());

                itemView.getContext().startActivity(intent);
            }
        });

    }
}
