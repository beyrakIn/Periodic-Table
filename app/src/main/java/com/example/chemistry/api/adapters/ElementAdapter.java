package com.example.chemistry.api.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chemistry.R;
import com.example.chemistry.api.models.Element;
import com.example.chemistry.api.views.ElementView;
import com.example.chemistry.views.AtomView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

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
        holder.elementName.setText(element.getName());
        holder.iconLatinName.setText(element.getName());
        holder.elementElectronConf.setText(element.getElectron_configuration_semantic());
        holder.iconName.setText(element.getSymbol());
        holder.iconRowNumber.setText(String.valueOf((int) element.getNumber()));
        try {
            if (element.getCpk_hex().equals("ffffff"))
                holder.elementCard.setBackgroundColor(context.getResources().getColor(R.color.purple_200));
            else
                holder.elementCard.setBackgroundColor(Color.parseColor('#' + element.getCpk_hex()));

        } catch (Exception e) {

        }

        holder.itemView.setOnClickListener(v -> {
            Activity activity = (AppCompatActivity) v.getContext();
            View view = LayoutInflater.from(activity).inflate(R.layout.bottom_sheet, null);

            TextView elementName, electronConf, electronConfSem;
            ImageView phase;
            LinearLayout options;

            phase = view.findViewById(R.id.bottom_sheet_phase);
            elementName = view.findViewById(R.id.bottom_sheet_element_name);
            electronConf = view.findViewById(R.id.bottom_sheet_electron_conf);
            electronConfSem = view.findViewById(R.id.bottom_sheet_electron_conf_sem);
            options = view.findViewById(R.id.bottom_sheet_options);


            elementName.setText(element.getName());
            electronConf.setText(element.getElectron_configuration());
            electronConfSem.setText(element.getElectron_configuration_semantic());

            options.addView(setTextView("Appearance", element.getAppearance(), context));
            options.addView(setTextView("Atomic mass", String.valueOf(element.getAtomic_mass()), context));
            options.addView(setTextView("Boil", String.valueOf(element.getBoil()), context));
            options.addView(setTextView("category", String.valueOf(element.getCategory()), context));
            options.addView(setTextView("color", String.valueOf(element.getColor()), context));
            options.addView(setTextView("density", String.valueOf(element.getDensity()), context));
            options.addView(setTextView("discovered by", String.valueOf(element.getDiscovered_by()), context));
            options.addView(setTextView("melt", String.valueOf(element.getMelt()), context));
            options.addView(setTextView("molar heat", String.valueOf(element.getMolar_heat()), context));
            options.addView(setTextView("named by", String.valueOf(element.getNamed_by()), context));
            options.addView(setTextView("number", String.valueOf((int) element.getNumber()), context));
            options.addView(setTextView("period", String.valueOf(element.getPeriod()), context));
            options.addView(setTextView("summary", String.valueOf(element.getSummary()), context));
            options.addView(setTextView("symbol", String.valueOf(element.getSymbol()), context));
            options.addView(setTextView("electron affinity", String.valueOf(element.getElectron_affinity()), context));
            options.addView(setTextView("electronegativity pauling", String.valueOf(element.getElectronegativity_pauling()), context));
            options.addView(setTextView("ionization energies", element.getIonization_energies(), context));
//            options.addView(setTextView("", String.valueOf(element), context));
//            options.addView(setTextView("", String.valueOf(element), context));
            options.addView(setTextView("source", String.valueOf(element.getSource()), context));
            switch (element.getPhase()) {
                case "Solid":
                    phase.setImageResource(R.drawable.solid);
                    break;
                case "Liquid":
                    phase.setImageResource(R.drawable.liquid);
                    break;
                case "Gas":
                    phase.setImageResource(R.drawable.gas);
                    break;
                case "Unknown":
                    phase.setImageResource(R.drawable.unknown);
                    break;
            }


            AtomView atomView = view.findViewById(R.id.bottom_sheet_atom_view);
            atomView.setShells(element.getShells());
            atomView.setSymbol(element.getSymbol());

            try {

                if (element.getCpk_hex().equals("ffffff")) {
                    atomView.setColor(context.getResources().getColor(R.color.purple_200));
                    atomView.setStrokeColor(context.getResources().getColor(R.color.purple_200));
                } else {
                    atomView.setColor(Color.parseColor('#' + element.getCpk_hex()));
                    atomView.setStrokeColor(Color.parseColor('#' + element.getCpk_hex()));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();
        });
    }

    private LinearLayout setTextView(String titleText, String s, Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView title = new TextView(context);
        TextView desc = new TextView(context);
        linearLayout.setGravity(Gravity.CENTER);

        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setText(titleText);
        title.setAllCaps(true);
        title.setTextSize(16);
        title.setTypeface(ResourcesCompat.getFont(context, R.font.anton));

//        desc.setTextColor(Color.BLACK);
        desc.setGravity(Gravity.CENTER);
        desc.setText(s);
        desc.setTextSize(16);
        desc.setTypeface(ResourcesCompat.getFont(context, R.font.martel_sans_bold));

        linearLayout.addView(title);
        linearLayout.addView(desc);
        return linearLayout;
    }

    private LinearLayout setTextView(String titleText, List<Float> s, Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView title = new TextView(context);
        linearLayout.setGravity(Gravity.CENTER);

        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setText(titleText);
        title.setAllCaps(true);
        title.setTextSize(16);
        title.setTypeface(ResourcesCompat.getFont(context, R.font.anton));

//        desc.setTextColor(Color.BLACK);
        linearLayout.addView(title);

        for (Float i : s) {
            TextView desc = new TextView(context);
            desc.setGravity(Gravity.CENTER);
            desc.setText(String.valueOf(i));
            desc.setTextSize(16);
            desc.setTypeface(ResourcesCompat.getFont(context, R.font.martel_sans_bold));
            linearLayout.addView(desc);

        }

        return linearLayout;
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
