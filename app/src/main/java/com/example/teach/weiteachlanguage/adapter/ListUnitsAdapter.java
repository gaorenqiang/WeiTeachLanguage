package com.example.teach.weiteachlanguage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.teach.weiteachlanguage.R;
import com.example.teach.weiteachlanguage.bean.ListUnits;

import java.util.List;

/**
 * Created by gaonqiang on 2018/1/12.
 */

public class ListUnitsAdapter extends android.widget.BaseAdapter{

    private List<ListUnits> mData;
    private Context mContext;

    public ListUnitsAdapter(List<ListUnits> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return  mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View item_view, ViewGroup parent) {
        item_view = LayoutInflater.from(mContext).inflate(R.layout.item_list_units,parent,false);
        TextView tv_unit = item_view.findViewById(R.id.tv_unit);
        TextView tv_theme = item_view.findViewById(R.id.tv_theme);
        TextView btn_state =item_view.findViewById(R.id.tv_state);
        TextView btn_next =item_view.findViewById(R.id.btn_next);
        //将按钮关联点击事件，如果要开启列表项自身的点击事件而屏蔽按钮本身的事件，
        // 请在item局部中设置descendantFocusability为blocksDescendants
        //btn_next.setOnClickListener(new ListUnitsAdapterListener());
        tv_unit.setText(mData.get(position).getUnitName());
        tv_theme.setText(mData.get(position).getTheme());
        btn_next.setTag(position);
        if(mData.get(position).getExerciseState())
            btn_state.setText("继续练习");
        else
            btn_state.setText("");

        return item_view;
    }

    public class ListUnitsAdapterListener implements View.OnClickListener{
        /**
         * 响应按钮点击事件
         * @param v
         */
        public void onClick(View v) {
            Toast.makeText(mContext,"listview的内部的按钮被点击了！位置是:" + (Integer) v.getTag() + ",内容是:"
                    + mData.get((Integer)v.getTag()).getUnitName(),Toast.LENGTH_SHORT).show();
        }
    }
}
