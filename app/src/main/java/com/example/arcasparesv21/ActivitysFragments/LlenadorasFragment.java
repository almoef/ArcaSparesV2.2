package com.example.arcasparesv21.ActivitysFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.arcasparesv21.Llenadoras.Llenadora_element;
import com.example.arcasparesv21.R;

public class LlenadorasFragment extends Fragment {
  private Button llenadoraKrones;
  private Button llenadoraSidel;


  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_llenadoras, container, false);
    llenadoraKrones = view.findViewById(R.id.llenadoraKrones);
    llenadoraSidel = view.findViewById(R.id.llneadoraSidel);

    llenadoraSidel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String NameLlenad = "Sidel";
        Intent ActivityElement = new Intent(getContext(), Llenadora_element.class);
        ActivityElement.putExtra("Llenadora",NameLlenad);
        startActivity(ActivityElement);
      }
    });

    llenadoraKrones.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String NameLlenad = "Krones";
        Intent ActivityElement = new Intent(getContext(), Llenadora_element.class);
        ActivityElement.putExtra("Llenadora",NameLlenad);
        startActivity(ActivityElement);
      }
    });
    return view;
  }
}
