package com.example.arcasparesv21.Etiquetadoras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.arcasparesv21.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class CardView_Config extends DialogFragment {

  private ProgressBar progressBar_image;
  LinearLayout linearLayout;
  @Override
  public void onCreate(Bundle savedInstancesState) {
    super.onCreate(savedInstancesState);
    setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogFragmentStyle);
  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_element, container, false);
    linearLayout = rootView.findViewById(R.id.linearLayout_3);
    TextView txt_codsap = rootView.findViewById(R.id.txt_codsap);
    TextView txt_descrip = rootView.findViewById(R.id.txt_descrip);
    TextView txt_nombtec = rootView.findViewById(R.id.txt_nombtec);
    TextView txt_numpart = rootView.findViewById(R.id.txt_numpart);
    TextView txt_marca = rootView.findViewById(R.id.txt_marca);
    ImageView imageView = rootView.findViewById(R.id.imageView);
    progressBar_image = rootView.findViewById(R.id.progressBar_image);


    // Configura un OnClickListener para el botón de cerrar
    rootView.findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Cierra el fragmento
        FragmentManager fragmentManager = requireFragmentManager();
        fragmentManager.popBackStack();
      }
    });
    rootView.findViewById(R.id.txt_cerrar).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Cierra el fragmento
        FragmentManager fragmentManager = requireFragmentManager();
        fragmentManager.popBackStack();
      }
    });
    Bundle bundle = getArguments();
    if(bundle != null){
      String message = bundle.getString("message");
      String [] parts = message.split(";");
      String message1,message2,message3,message4,message5,message6;
      if(parts.length >= 6)
      {
        message1 = parts [0];
        message2 = parts [1];
        message3 = parts [2];
        message4 = parts [3];
        message5 = parts [4];
        message6 = parts [5];

        imageView.setVisibility(View.INVISIBLE);
        progressBar_image.setVisibility(View.VISIBLE);
        Picasso.get().load(message6).into(imageView, new Callback() {
          @Override
          public void onSuccess() {
            // La imagen se ha cargado correctamente, oculta el ProgressBar y muestra la ImageView
            progressBar_image.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
          }

          @Override
          public void onError(Exception e) {
            // Manejar errores si la imagen no se carga correctamente
            // Puedes mostrar un mensaje de error o realizar otra acción apropiada
          }
        });
        //Picasso.get().load(message6).into(imageView);
        txt_codsap.setText(message1);
        txt_nombtec.setText(message2);
        txt_numpart.setText(message3);
        txt_descrip.setText(message4);
        txt_marca.setText(message5);
      }
    }

    return rootView;
  }
}