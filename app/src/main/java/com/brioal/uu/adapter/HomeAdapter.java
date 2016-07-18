package com.brioal.uu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brioal.uu.R;
import com.brioal.uu.entity.HomeContentEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brioal on 2016/7/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ContentViewHolder> {

    private Context mContext;
    private List<HomeContentEntity> mList;

    public HomeAdapter(Context context, List<HomeContentEntity> list) {
        mContext = context;
        mList = list;
    }


    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_content, parent, false));
    }

    @Override
    public void onBindViewHolder(final ContentViewHolder holder, int position) {
        HomeContentEntity entity = mList.get(position);
        Glide.with(mContext).load(entity.getImageUrl()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                holder.mIvImage.setImageDrawable(resource);
            }
        });
        holder.mTvName.setText(entity.getName());
        holder.mTvCollectCount.setText(entity.getLikeNums() + "");
        holder.mTvPrice.setText("¥" + entity.getPrice());
        holder.mTvGold.setText("返" + entity.getCold() + "金币");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2016/7/18 跳转商品详情
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class ContentViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_content_iv_image)
        ImageView mIvImage;
        @Bind(R.id.item_content_tv_collect_count)
        TextView mTvCollectCount;
        @Bind(R.id.item_content_iv_name)
        TextView mTvName;
        @Bind(R.id.item_content_iv_price)
        TextView mTvPrice;
        @Bind(R.id.item_content_iv_gold)
        TextView mTvGold;

        View itemView ;
        public ContentViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this,itemView);
        }
    }
}
