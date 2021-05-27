package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.vcode.Quiz1;
import com.example.vcode.Quiz2;
import com.example.vcode.Quiz3;
import com.example.vcode.Quiz4;
import com.example.vcode.Quiz5;
import com.example.vcode.Quiz6;
import com.example.vcode.Quiz7;
import com.example.vcode.Quiz8;
import com.example.vcode.Quiz9;
import com.example.vcode.R;

import java.util.List;

import Model.Items;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private Context context;
    private List<Items> items;
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlerow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Items row=items.get(position);
        holder.rowId.setText(row.getRowId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(items.get(position).getRowId().matches("Quiz:Variables")){
                    Intent gotoActivity=new Intent(context, Quiz1.class);
                    context.startActivity(gotoActivity);
                }else if(items.get(position).getRowId().matches("Quiz:literals")){
                    Intent gotoActivity=new Intent(context, Quiz2.class);
                    context.startActivity(gotoActivity);
                }else if(items.get(position).getRowId().matches("Quiz:Operators")){
                    Intent gotoActivity=new Intent(context, Quiz3.class);
                    context.startActivity(gotoActivity);
                }else if(items.get(position).getRowId().matches("Quiz:Decision making")){
                    Intent gotoActivity=new Intent(context, Quiz4.class);
                    context.startActivity(gotoActivity);
                }else if(items.get(position).getRowId().matches("Quiz:Loops")){
                    Intent gotoActivity=new Intent(context, Quiz5.class);
                    context.startActivity(gotoActivity);
                }else if(items.get(position).getRowId().matches("Quiz:Functions")){
                    Intent gotoActivity=new Intent(context, Quiz6.class);
                    context.startActivity(gotoActivity);
                }else if(items.get(position).getRowId().matches("Quiz:Arrays")){
                    Intent gotoActivity=new Intent(context, Quiz7.class);
                    context.startActivity(gotoActivity);
                }else if(items.get(position).getRowId().matches("Quiz:Structures")){
                    Intent gotoActivity=new Intent(context, Quiz8.class);
                    context.startActivity(gotoActivity);
                }else if(items.get(position).getRowId().matches("Quiz:Pointers")){
                    Intent gotoActivity=new Intent(context, Quiz9.class);
                    context.startActivity(gotoActivity);
                }
            }
        });
    }

    public MyAdapter(Context context, List<Items> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowId;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowId=itemView.findViewById(R.id.txt1);
        }
    }
}
