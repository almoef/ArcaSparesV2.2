package com.example.arcasparesv21.Llenadoras.AdapterSparesLlenad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arcasparesv21.Llenadoras.ModelSapresLlenad.ModelSparesLlenad;
import com.example.arcasparesv21.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AdapterSparesLlenad extends FirebaseRecyclerAdapter<ModelSparesLlenad, AdapterSparesLlenad.ViewHolder> {
  private ProgressBar progressBar;
  private LinearLayout recyclerViewContainer;
  public AdapterSparesLlenad(@NonNull FirebaseRecyclerOptions<ModelSparesLlenad> options,ProgressBar progressBar, LinearLayout recyclerViewContainer) {
    super(options);
    this.progressBar = progressBar;
    this.recyclerViewContainer = recyclerViewContainer;
  }

  @Override
  protected void onBindViewHolder(@NonNull AdapterSparesLlenad.ViewHolder holder, int position, @NonNull ModelSparesLlenad model) {
    holder.CodigoSap.setText(model.getCódigoSAP());
    holder.DescripcionBreve.setText(model.getDescripciónBreve());
    holder.NombreTecnico.setText(model.getNombreTécnico());
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
  public AdapterSparesLlenad.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spareparts_view, parent, false);
    return new ViewHolder(v);
  }


  public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView CodigoSap,DescripcionBreve,NombreTecnico;
    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      CodigoSap = itemView.findViewById(R.id.cod_sap);
      DescripcionBreve = itemView.findViewById(R.id.element);
      NombreTecnico = itemView.findViewById(R.id.nombreTecnico);
    }
}
}
