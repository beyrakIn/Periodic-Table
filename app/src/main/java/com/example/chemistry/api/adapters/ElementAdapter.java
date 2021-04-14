package com.example.chemistry.api.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chemistry.api.models.Element;
import com.example.chemistry.api.views.ElementView;

import java.util.List;

import com.example.chemistry.R;

public class ElementAdapter extends RecyclerView.Adapter<ElementView> {
    private Context context;
    private List<Element> elements;


    public ElementAdapter(Context context, List<Element> elements) {
        this.context = context;
        this.elements = elements;
    }

    @NonNull
    @Override
    public ElementView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_card, parent, false);
        return new ElementView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementView holder, int position) {
        Element element = elements.get(position);
        holder.textView.setText(element.getElement());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
