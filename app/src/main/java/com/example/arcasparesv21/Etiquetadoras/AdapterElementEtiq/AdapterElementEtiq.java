package com.example.arcasparesv21.Etiquetadoras.AdapterElementEtiq;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arcasparesv21.Etiquetadoras.Activity_Spares;
import com.example.arcasparesv21.Etiquetadoras.ModelElementEtiq.ModelElementEtiq;
import com.example.arcasparesv21.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AdapterElementEtiq extends FirebaseRecyclerAdapter<ModelElementEtiq,AdapterElementEtiq.ViewHolder> {
  private String nameEtiq;
  private ProgressBar progressBar;
  private LinearLayout recyclerViewContainer;
  public AdapterElementEtiq(@NonNull FirebaseRecyclerOptions<ModelElementEtiq> options,String nameEtiq, ProgressBar progressBar, LinearLayout recyclerViewContainer) {
    super(options);
    this.nameEtiq = nameEtiq;
    this.progressBar = progressBar;
    this.recyclerViewContainer = recyclerViewContainer;
  }

  @Override
  protected void onBindViewHolder(@NonNull AdapterElementEtiq.ViewHolder holder, int position, @NonNull ModelElementEtiq model) {
    holder.textElement.setText(model.getNombreElemento());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String Elemento = model.getNombreElemento();
        Intent nextActivity = new Intent(view.getContext(), Activity_Spares.class);
        nextActivity.putExtra("element",Elemento); //envia el elemento apra filtrar
        nextActivity.putExtra("Etiq",nameEtiq); // envia el tipo de etiq
        view.getContext().startActivity(nextActivity);
      }
    });
  }
  @Override
  public void onDataChanged() {
    super.onDataChanged();
    // Los datos se han cargado, oculta el ProgressBar y muestra el RecyclerView
    progressBar.setVisibility(View.GONE);
    recyclerViewContainer.setVisibility(View.VISIBLE);
  }
  @NonNull
  @Override
  public AdapterElementEtiq.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_view,parent,false);
    return new ViewHolder(v);
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView textElement;
    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      textElement = itemView.findViewById(R.id.txtElement);
    }
  }
}
