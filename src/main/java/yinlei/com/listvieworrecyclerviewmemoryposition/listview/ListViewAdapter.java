package yinlei.com.listvieworrecyclerviewmemoryposition.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yinlei.com.listvieworrecyclerviewmemoryposition.R;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: ListViewAdapter.java
 * @author: 若兰明月
 * @date: 2016-09-17 10:47
 */

public class ListViewAdapter extends BaseAdapter {

    private List<String> mStrings = new ArrayList<>();
    private Context mContext;

    public ListViewAdapter(List<String> strings,Context context) {
        this.mStrings = strings;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mStrings.size() == 0 ? 0 : mStrings.size();
    }

    @Override
    public Object getItem(int i) {
        return mStrings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            holder = new ViewHolder();
            view =LayoutInflater.from(mContext).inflate(R.layout.list_view_layout_item,null);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mTextView = (TextView) view.findViewById(R.id.tv_title);
        holder.mReRe = (RelativeLayout) view.findViewById(R.id.re_re);
        if (mPosition == i) {
            holder.mReRe.setBackground(mContext.getResources().getDrawable(R.drawable.spinner_ab_focused_example));
        } else {
            holder.mReRe.setBackground(mContext.getResources().getDrawable(R.drawable.spinner_ab_disabled_example));
        }
        holder.mTextView.setText(mStrings.get(i));
        return view;
    }

    //默认是第几项
    private int mPosition = 3;

    public void setPosition(int position) {
        mPosition = position;
    }

    public class ViewHolder {
        TextView mTextView;
        public RelativeLayout mReRe;
    }
}
