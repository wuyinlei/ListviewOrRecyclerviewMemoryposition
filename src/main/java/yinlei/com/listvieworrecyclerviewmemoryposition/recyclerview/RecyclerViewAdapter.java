package yinlei.com.listvieworrecyclerviewmemoryposition.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yinlei.com.listvieworrecyclerviewmemoryposition.R;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: RecyclerViewAdapter.java
 * @author: 若兰明月
 * @date: 2016-09-17 11:20
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> mStrings = new ArrayList<>();

    public RecyclerViewAdapter(List<String> strings){
        this.mStrings = strings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mPosition == position){
            holder.mReRe.setBackground(holder.itemView.getContext().getResources().getDrawable(R.drawable.spinner_ab_focused_example));
        } else {
            holder.mReRe.setBackground(holder.itemView.getContext().getResources().getDrawable(R.drawable.spinner_ab_disabled_example));
        }
        holder.mTextView.setText(mStrings.get(position));
    }

    //默认第几项
    private int mPosition = 0;

    public void setPosition(int position) {
        mPosition = position;
    }

    @Override
    public int getItemCount() {
        return mStrings.size() == 0?0:mStrings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout mReRe;
        private TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mReRe = (RelativeLayout) itemView.findViewById(R.id.re_re);
            mTextView = (TextView) itemView.findViewById(R.id.tv_title);
            mReRe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick(view,getLayoutPosition(),mStrings.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, String s);
    }
}
