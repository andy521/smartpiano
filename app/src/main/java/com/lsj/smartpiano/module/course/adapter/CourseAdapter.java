package com.lsj.smartpiano.module.course.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lsj.smartpiano.R;
import com.lsj.smartpiano.module.course.bean.CourseListBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shiny_jia
 * on 2016-06-02 22:19.KaraGameAdapter
 */
public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private Context mContext;
    private List<CourseListBean.DataEntity.SubsEntity.ListEntity> dataList;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public CourseAdapter(Context context, List<CourseListBean.DataEntity.SubsEntity.ListEntity> dataList) {
        this.dataList = dataList;
        mContext = context;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advance_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if ("".equals(dataList.get(position).getUrl())) {

        } else {
            Picasso.with(mContext)
                    .load(dataList.get(position).getUrl())
                    .into(holder.icListPic);
        }
        holder.tvName.setText(dataList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onItemClick(holder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.ic_list_pic)
        ImageView icListPic;
        @Bind(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}