package com.speedsumm.bu.contentp;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static Uri TASK_URI = Uri.parse("content://com.speedsumm.bu/tasks");
    ArrayList<Task> taskArrayList = new ArrayList<>();
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new MyAdapter(this, taskArrayList);
        ListView listView = (ListView) findViewById(R.id.lvContact);
        listView.setAdapter(adapter);


    }


    public ArrayList<Task> OnClick(View v) {

        switch (v.getId()) {
            case R.id.allTasks:
                TASK_URI = Uri.parse("content://com.speedsumm.bu/tasks/");
                taskListCreate();
                break;

            case R.id.firstTask:
                TASK_URI = Uri.parse("content://com.speedsumm.bu/tasks/1");
                taskListCreate();
                break;

            case R.id.compTasks:
                TASK_URI = Uri.parse("content://com.speedsumm.bu/tasks/comp");
                taskListCreate();
                break;
//            case R.id.deleteTask:
//                getContentResolver().delete(TASK_URI,)
//                Log.d(".....","All tasks deleted");
//                break;
            case R.id.insertTask:
                ContentValues cv = new ContentValues();
                cv.put("N_TASK", "НОвая задача из RESOLVER");
                cv.put("B_TASK", "Задача всалена в базу через механизм RESOLVER");
                cv.put("E_TASK", "01.02.2016");
                Uri uri = getContentResolver().insert(TASK_URI, cv);
                return taskArrayList;
        }
        return taskArrayList;
    }

    private ArrayList<Task> taskListCreate() {
        Cursor cursor;
        taskArrayList.clear();
        cursor = getContentResolver().query(TASK_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            Task task = new Task();
            task.setName(cursor.getString(cursor.getColumnIndex("N_TASK")));
            task.setBody(cursor.getString(cursor.getColumnIndex("B_TASK")));
            task.setDate(cursor.getString(cursor.getColumnIndex("E_TASK")));
            taskArrayList.add(task);
            adapter.notifyDataSetChanged();

        }
        return taskArrayList;
    }
}