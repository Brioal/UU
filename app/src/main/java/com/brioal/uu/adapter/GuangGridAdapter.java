package com.brioal.uu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brioal.uu.R;
import com.brioal.uu.entity.GuangEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brioal on 2016/7/19.
 */

public class GuangGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<GuangEntity> mList;

    public GuangGridAdapter(Context context, List<GuangEntity> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_shop_detail, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        GuangEntity entity = mList.get(position);
        final ViewHolder finalHolder = holder;
        Glide.with(mContext).load(entity.getImageUrl()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                finalHolder.mDetailImage.setImageDrawable(resource);

            }
        });
        holder.mDetailBack.setText(entity.getTitle());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_shop_detail_image)
        ImageView mDetailImage;
        @Bind(R.id.item_shop_detail_back)
        TextView mDetailBack;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
