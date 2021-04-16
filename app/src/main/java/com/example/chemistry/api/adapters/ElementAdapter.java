package com.example.chemistry.api.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chemistry.R;
import com.example.chemistry.api.models.Element;
import com.example.chemistry.AtomView;
import com.example.chemistry.api.views.ElementView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        holder.itemView.setOnClickListener(v -> {
            Activity activity = (AppCompatActivity) v.getContext();
            View view = LayoutInflater.from(activity).inflate(R.layout.bottom_sheet, null);

            TextView textView = view.findViewById(R.id.bottom_sheet_details);
            AtomView atomView = view.findViewById(R.id.bottom_sheet_atom_view);

            Integer[] shells = {
                    2,
                    8,
                    18,
                    8,
                    1
            };
            List<Integer> shell = new ArrayList<>();
            Collections.addAll(shell, shells);
            atomView.setShells(shell);
            textView.setText(element.toString());


            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
