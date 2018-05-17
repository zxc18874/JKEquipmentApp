package com.jk.jkequipmentapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jk.jkequipmentapp.R;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public class MachineListAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<String> mDatas;
    private OnItemClickListener mItemClickListener;
    public MachineListAdapter(Context context, List<String> datas) {
        super();
        this.mContext = context;
        this.mDatas = datas;
    }
    //item的回调接口
    public interface OnItemClickListener{
        void onItemClick(View view,int Position);
    }
    //定义一个设置点击监听器的方法
    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;

    }
    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return mDatas.size();


    }

   // @Override
    // 填充onCreateViewHolder方法返回的holder中的控件
  /*  public void onBindViewHolder(MyHolder holder, int position) {
        // TODO Auto-generated method stub
        holder.imageView.setImageResource(mDatas.get(position));
    }*/

    @Override
    // 重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    public MyHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        // 填充布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.machine_list_item, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        ( (MyHolder)holder).machine_item_nametxt.setText(mDatas.get(position));
        //如果设置了回调，则设置点击事件
        if(mItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(( (MyHolder)holder).itemView, position);

                }
            });
        }
    }

    // 定义内部类继承ViewHolder
    class MyHolder extends RecyclerView.ViewHolder {

        private TextView machine_item_nametxt;

        public MyHolder(View view) {
            super(view);
            machine_item_nametxt = (TextView) view.findViewById(R.id.machine_item_nametxt);
        }

    }
}
