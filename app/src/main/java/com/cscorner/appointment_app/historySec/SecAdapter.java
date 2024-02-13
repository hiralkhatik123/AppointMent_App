package com.cscorner.appointment_app.historySec;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cscorner.appointment_app.R;

import java.util.ArrayList;

public class SecAdapter  extends RecyclerView.Adapter<SecAdapter.myviewHolder> {
    private Context context;
    private ArrayList _id,_Name,_Age;
    Activity activity;

    SecAdapter(Activity activity,Context context, ArrayList _id, ArrayList _Name, ArrayList _Age){
        this.activity = activity;
        this.context = context;
        this._Name = _Name;
        this._Age = _Age;
        this._id = _id;
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow,parent,false);
        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        holder.id.setText(String.valueOf(_id.get(position)));
        holder.name.setText(String.valueOf(_Name.get(position)));
        holder.age.setText(String.valueOf(_Age.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, secupdateActivity.class);
                intent.putExtra("id",String.valueOf(_id.get(position)));
                intent.putExtra("name",String.valueOf(_Name.get(position)));
                intent.putExtra("age",String.valueOf(_Age.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return _id.size();
    }

    public class myviewHolder extends RecyclerView.ViewHolder {
            TextView name,age;
            TextView id;
            LinearLayout mainLayout;

        public myviewHolder(@NonNull View itemView) {
                super(itemView);
                name = (TextView)itemView.findViewById(R.id.name);
                age =(TextView) itemView.findViewById(R.id.age);
                id  =(TextView) itemView.findViewById(R.id.id);
                mainLayout = itemView.findViewById(R.id.mainLayout);
            }
    }
}
