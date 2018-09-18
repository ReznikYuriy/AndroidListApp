package com.example.yuriy.mylistapp;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    // имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    final String ATTRIBUTE_NAME_GROUP = "group";

    ListView lvSimple;
    ArrayList<Student> studList = new ArrayList<Student>();
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        // упаковываем данные в понятную для адаптера структуру
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                studList.size());
        Map<String, Object> m;
        for (Student s: studList) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, s.name);
            m.put(ATTRIBUTE_NAME_CHECKED, s.isChecked);
            m.put(ATTRIBUTE_NAME_IMAGE, s.image);
            m.put(ATTRIBUTE_NAME_GROUP, s.group);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED,
                ATTRIBUTE_NAME_IMAGE, ATTRIBUTE_NAME_GROUP };
        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = { R.id.tvName, R.id.cbChecked, R.id.ivImg, R.id.tvGroup };

        // создаем адаптер
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item,
                from, to);

        // определяем список и присваиваем ему адаптер
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
    }
    void fillData() {
        studList.add(new Student("Marya", "PP-2709", R.drawable.female, false));
        studList.add(new Student("Marya", "PP-2709", R.drawable.female, false));
        studList.add(new Student("Marya", "PP-2709", R.drawable.female, false));
        studList.add(new Student("Marya", "PP-2709", R.drawable.female, false));
        }
}