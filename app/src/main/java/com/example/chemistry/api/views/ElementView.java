package com.example.chemistry.api.views;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chemistry.R;

public class ElementView extends RecyclerView.ViewHolder {
    public LinearLayout elementsCard;
    public RelativeLayout elementCard;
    public TextView elementName, iconName, iconRowNumber, iconLatinName, elementElectronConf;
    public ElementView(@NonNull View itemView) {
        super(itemView);

        elementsCard = itemView.findViewById(R.id.bottom_sheet_element_card);
        elementCard = itemView.findViewById(R.id.element_card_color);
        elementName = itemView.findViewById(R.id.element_card_name);
        iconName = itemView.findViewById(R.id.icon_name);
        elementElectronConf = itemView.findViewById(R.id.element_card_electron_conf);
        iconLatinName = itemView.findViewById(R.id.icon_latin_names);
        iconRowNumber = itemView.findViewById(R.id.icon_row_number);
    }
}
