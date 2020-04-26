package ir.technopedia.listadaptermultiview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import ir.technopedia.listadaptermultiview.adapter.MultiTypeAdapter;
import ir.technopedia.listadaptermultiview.model.Cat;
import ir.technopedia.listadaptermultiview.model.Model;
import ir.technopedia.listadaptermultiview.model.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recycler;
    Button btn_random;
    List<Model> listData = new ArrayList<>();
    MultiTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findUiItems();
        listData = getRecyclerData();
        btn_random.setOnClickListener(this);

        adapter = new MultiTypeAdapter();
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
        adapter.submitList(listData);
    }

    public void findUiItems() {
        btn_random = findViewById(R.id.btn_random);
        recycler = findViewById(R.id.recycler);
    }

    public List<Model> getRecyclerData() {
        List<Model> data = new ArrayList<>();
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        for (int i = 0; i < randomNumber; i++) {
            data.add(new Person("Person " + i + " name", "Person " + i + " Last name"));
        }
        randomNumber = random.nextInt(5);
        for (int i = 0; i < randomNumber; i++) {
            data.add(new Cat("Cat name " + (i + 1), "Cat register : 00" + i));
        }
        Collections.shuffle(data);
        return data;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_random:
                listData = getRecyclerData();
                adapter.submitList(listData);
        }

    }
}
