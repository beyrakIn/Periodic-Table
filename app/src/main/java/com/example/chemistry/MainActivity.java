package com.example.chemistry;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chemistry.api.Progress;
import com.example.chemistry.api.adapters.ElementAdapter;
import com.example.chemistry.api.methods.GetElements;
import com.example.chemistry.api.models.Element;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Progress progress;
    SearchView searchView;
    private RecyclerView recyclerView;
    private ElementAdapter elementAdapter;
    private List<Element> elements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = new Progress(this);
        progress.start();
        recyclerView = findViewById(R.id.recycler_view);

        loadData();
    }

    private void loadData() {
        try {
            new GetElements().getElements().enqueue(new Callback<List<Element>>() {
                @Override
                public void onResponse(Call<List<Element>> call, Response<List<Element>> response) {
                    if (response.isSuccessful()) {
                        elements = response.body();
                        elementAdapter = new ElementAdapter(getApplicationContext(), elements);
                        recyclerView.setAdapter(elementAdapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setItemViewCacheSize(150);
                        elementAdapter.notifyDataSetChanged();
                        progress.stop();
                    } else {
                        Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<Element>> call, Throwable t) {
                    loadData();
                }
            });
        } catch (Exception e) {
            loadData();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.search_menu, menu);
            MenuItem item = menu.findItem(R.id.search_action);
            searchView = (SearchView) item.getActionView();
            searchView.setOnQueryTextListener(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;    //super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        elementAdapter.getFilter().filter(query);
        elementAdapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        elementAdapter.getFilter().filter(newText);
        elementAdapter.notifyDataSetChanged();
        return false;
    }

}