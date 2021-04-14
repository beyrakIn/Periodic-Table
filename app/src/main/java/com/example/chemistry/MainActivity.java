package com.example.chemistry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chemistry.api.adapters.ElementAdapter;
import com.example.chemistry.api.methods.GetElements;
import com.example.chemistry.api.models.Element;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ElementAdapter elementAdapter;
    List<Element> elements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        recyclerView = findViewById(R.id.recycler_view);


        try {
            new GetElements().getElements().enqueue(new Callback<List<Element>>() {
                @Override
                public void onResponse(Call<List<Element>> call, Response<List<Element>> response) {
                    if (response.isSuccessful()){
                        elements = response.body();
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                                RecyclerView.VERTICAL, false);
                        elementAdapter = new ElementAdapter(getApplicationContext(), elements);
                        recyclerView.setAdapter(elementAdapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setItemViewCacheSize(100);
                        elementAdapter.notifyDataSetChanged();
                    }
                    System.out.println(response.code());
                    System.out.println(response.message());
                    System.out.println(response.body());
                }

                @Override
                public void onFailure(Call<List<Element>> call, Throwable t) {
                    System.out.println(t.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}