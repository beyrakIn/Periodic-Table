package com.example.chemistry.api.views;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chemistry.R;

public class ElementView extends RecyclerView.ViewHolder {
    public TextView textView;
    public ElementView(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.element_name);
    }
}
