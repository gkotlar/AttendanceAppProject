package com.example.attendanceappproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Timestamp;
import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {

    public ClassAdapter(List<ClassItem> classList) {
        this.classList = classList;
    }

    @NonNull
    @Override
    public ClassAdapter.ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);
        return new ClassViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassAdapter.ClassViewHolder holder, int position) {
        ClassItem classItem = classList.get(position);
        holder.ClassName.setText(classItem.getClassName());
        holder.About.setText(classItem.getAbout());
        holder.location.setText(classItem.getLocation());
        holder.time.setText(classItem.getTime());
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    private List<ClassItem> classList;
    public static class ClassViewHolder extends RecyclerView.ViewHolder{
        TextView time;
        TextView location;
        TextView ClassName;
        TextView About;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            ClassName = itemView.findViewById(R.id.Text_Header);
            About = itemView.findViewById(R.id.Text_SubHeader);
            location = itemView.findViewById(R.id.Text_Line_First);
            time = itemView.findViewById(R.id.Text_Line_Trird);
        }
    }

}
