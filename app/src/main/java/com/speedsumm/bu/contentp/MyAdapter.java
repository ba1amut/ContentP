package com.speedsumm.bu.contentp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bu on 20.07.2016.
 */
public class MyAdapter extends ArrayAdapter <Task>{


    public MyAdapter(Context context,  List<Task> taskList) {
        super(context, 0, taskList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task taskName = getItem(position);
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.task_list,parent,false);

        TextView nameTask = (TextView)convertView.findViewById(R.id.taskName);
        TextView bodyTask= (TextView)convertView.findViewById(R.id.taskBody);
        TextView dateTask = (TextView)convertView.findViewById(R.id.taskDate);
        nameTask.setText(taskName.getName());
        bodyTask.setText(taskName.getBody());
        dateTask.setText(taskName.getDate());

        return convertView;



    }
}
