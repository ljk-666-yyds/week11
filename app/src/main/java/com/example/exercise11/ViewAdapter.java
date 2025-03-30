package com.example.exercise11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    private List<String> data;

    public ViewAdapter(List<String> data) {
        this.data = data;
    }
    public void updateData(List<String> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position));  // 设置 textView 显示数据
    }

    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}








