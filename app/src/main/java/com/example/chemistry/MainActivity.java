package com.example.chemistry;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chemistry.api.adapters.ElementAdapter;
import com.example.chemistry.api.methods.GetElements;
import com.example.chemistry.api.models.Element;
import com.example.chemistry.views.Progress;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Progress progress;
    private RecyclerView recyclerView;
    private ElementAdapter elementAdapter;
    private List<Element> elements = new ArrayList<>();
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = new Progress(this);
        progress.start();
        recyclerView = findViewById(R.id.recycler_view);
        adView = findViewById(R.id.main_activity_adView);

        setLocale("Az");
        loadData();
        loadAd();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,
                getApplicationContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences(Constants.SETTINGS, MODE_PRIVATE).edit();
        editor.putString(Constants.LANG, lang);
        editor.apply();
    }

    private void changeLanguage() {
        final String[] languages = {"AZ", "TR", "RU", "EN"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose Language");
        builder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        setLocale("Az");
                        break;
                    case 1:
                        setLocale("Tr");
                        break;
                    case 2:
                        setLocale("Ru");
                        break;
                    case 3:
                        setLocale("En");
                        break;
                }

                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void loadAd() {
        MobileAds.initialize(this, initializationStatus -> {
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Toast.makeText(getApplicationContext(), "Sad(", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
                Toast.makeText(getApplicationContext(), "Thanks)", Toast.LENGTH_SHORT).show();
            }
        });
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
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.lang_action:
            changeLanguage();
            break;
        }
        return super.onOptionsItemSelected(item);
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