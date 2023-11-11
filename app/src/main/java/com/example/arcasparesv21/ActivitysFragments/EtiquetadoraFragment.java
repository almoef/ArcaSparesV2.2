package com.example.arcasparesv21.ActivitysFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.arcasparesv21.Etiquetadoras.Activity_Elements;
import com.example.arcasparesv21.R;

public class EtiquetadoraFragment extends Fragment {
  private Button ActivitySidel;
  private Button ActivityKrones;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_etiquetadoras, container, false);
    ActivitySidel = view.findViewById(R.id.btnSidel);
    ActivityKrones = view.findViewById(R.id.btnKrones);

    ActivitySidel.setOnClickListener(new AdapterView.OnClickListener() {
      @Override
      public void onClick(View view) {
        String NameEtiq = "Sidel";
        Intent ActivityElements = new Intent(getContext(), Activity_Elements.class);
        ActivityElements.putExtra("Etiq", NameEtiq);
        startActivity(ActivityElements);
      }
    });

    ActivityKrones.setOnClickListener(new AdapterView.OnClickListener() {
      @Override
      public void onClick(View view) {
        String NameEtiq = "Krones";
        Intent ActivityElements = new Intent(getContext(), Activity_Elements.class);
        ActivityElements.putExtra("Etiq", NameEtiq);
        startActivity(ActivityElements);
      }
    });
    return view;
  }
}