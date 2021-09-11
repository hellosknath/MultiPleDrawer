package com.sriidea.multipledrawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

/**
 * Created by srinath on 17:18, 11, September, 2021
 * Project Name: MultiPleDrawer;
 * Company name: Alchemy Software Ltd.
 */
public class CustomAdapter extends BaseAdapter {

    String[] result;
    Context con;
    int[] img;

    private static LayoutInflater layoutInflater = null;

    public CustomAdapter(String[] result, Context con, int[] img) {
        this.result = result;
        this.con = con;
        this.img = img;
        layoutInflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"CutPasteId", "ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        View view;
        view = layoutInflater.inflate(R.layout.gd_main, null);
        holder.tvTitle = view.findViewById(R.id.tvTitle);
        holder.img = view.findViewById(R.id.img);
        holder.cd_view = view.findViewById(R.id.cd_view);

        holder.tvTitle.setText(result[position]);
        holder.img.setImageResource(img[position]);

        holder.cd_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MainActivity().getInstance().hideDrawer();
            }
        });

        return view;
    }

    public class Holder {
        TextView tvTitle;
        ImageView img;
        CardView cd_view;
    }
}
