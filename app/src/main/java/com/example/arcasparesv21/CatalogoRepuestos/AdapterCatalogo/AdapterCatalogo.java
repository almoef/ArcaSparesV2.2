package com.example.arcasparesv21.CatalogoRepuestos.AdapterCatalogo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arcasparesv21.CatalogoRepuestos.ModelCatalogo.ModelCatalogo;
import com.example.arcasparesv21.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

public class AdapterCatalogo extends FirestoreRecyclerAdapter<ModelCatalogo,AdapterCatalogo.ViewHolder> {
  /**
   * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
   * FirestoreRecyclerOptions} for configuration options.
   *
   * @param options
   */
  public AdapterCatalogo(@NonNull FirestoreRecyclerOptions<ModelCatalogo> options) {
    super(options);
  }

  @Override
  protected void onBindViewHolder(@NonNull AdapterCatalogo.ViewHolder holder, int position, @NonNull ModelCatalogo model) {
    holder.material.setText(model.getMaterial());
    //holder.equipo.setText(model.getEquipo());
    holder.descripcionSap.setText(model.getDescripcionSap());
    holder.fabricanteComponente.setText(model.getFabricanteComponente());
    //holder.linea.setText(model.getLinea());
    holder.medidas.setText(model.getMedidas());
    holder.npFabricante.setText(model.getNpFabricante());
    holder.npProveedor.setText(model.getNpProveedor());
    holder.proveedorMaquina.setText(model.getProveedorMaquina());
    holder.textoExtendido.setText(model.getTextoExtendido());
    //holder.tipoDeMaterial.setText(model.getTipoDeMaterial());
    Picasso.get().load(model.getUrlImagen()).into(holder.imageView);
  }

  @NonNull
  @Override
  public AdapterCatalogo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalogo_view,parent,false);
    return new ViewHolder(v);
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView material, descripcionSap, equipo,fabricanteComponente,linea,medidas,npFabricante,npProveedor,proveedorMaquina,textoExtendido,tipoDeMaterial;
    private ImageView imageView;
    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      material = itemView.findViewById(R.id.material);
      //equipo = itemView.findViewById(R.id.equipo);
      descripcionSap = itemView.findViewById(R.id.descripcionSap);
      fabricanteComponente = itemView.findViewById(R.id.fabricanteComponente);
      //linea = itemView.findViewById(R.id.linea);
      medidas = itemView.findViewById(R.id.medidas);
      npFabricante = itemView.findViewById(R.id.npFabricante);
      npProveedor = itemView.findViewById(R.id.npProveedor);
      proveedorMaquina = itemView.findViewById(R.id.proveedorMaquina);
      textoExtendido = itemView.findViewById(R.id.textoExtendido);
      //tipoDeMaterial = itemView.findViewById(R.id.tipoDeMaterial);
      imageView = itemView.findViewById(R.id.imageView);
    }
  }
}
