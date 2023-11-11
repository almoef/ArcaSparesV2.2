package com.example.arcasparesv21.CatalogoRepuestos;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arcasparesv21.CatalogoRepuestos.AdapterCatalogo.AdapterCatalogo;
import com.example.arcasparesv21.CatalogoRepuestos.ModelCatalogo.ModelCatalogo;
import com.example.arcasparesv21.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class CatalogoFragment extends Fragment {

  RecyclerView mRecycler;
  AdapterCatalogo mAdapter;
  FirebaseFirestore mFirestore;
  Query query;
  EditText edt_search;
  ImageButton srchButton;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_catalogo, container, false);
    edt_search = view.findViewById(R.id.edt_srch);
    srchButton = view.findViewById(R.id.searchButton);

    edt_search.setOnKeyListener(new View.OnKeyListener() {
      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {

        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
          // Aquí puedes realizar la acción que desees
          textSearch(edt_search.getText().toString());
          //CIERRA EL TECLADO LUEGO DE PRESIONAR ENTER
          InputMethodManager inputMethodManager = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
          inputMethodManager.hideSoftInputFromWindow(requireActivity().getCurrentFocus().getWindowToken(), 0);
          return true; // Indicar que el evento ha sido manejado
        }
        return false; // Permitir que otros manejadores de eventos procesen la pulsación de tecla
      }
    });

    srchButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Realiza la búsqueda al hacer clic en el botón de búsqueda
        textSearch(edt_search.getText().toString());
        //CIERRA EL TECLADO LUEGO DE PRESIONAR ENTER
        InputMethodManager inputMethodManager = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(requireActivity().getCurrentFocus().getWindowToken(), 0);
      }
    });
    return view;
  }
  private void textSearch(String s) {
    mFirestore = FirebaseFirestore.getInstance();
    mRecycler = requireView().findViewById(R.id.recyclerView);
    mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    //query = mFirestore.collection("catalogo_repuestos");
    query = mFirestore.collection("CatalogRep").whereEqualTo("material", s);
    FirestoreRecyclerOptions<ModelCatalogo> firestoreRecyclerOptions =
            new FirestoreRecyclerOptions.Builder<ModelCatalogo>().setQuery(query,ModelCatalogo.class).build();
    mAdapter = new AdapterCatalogo(firestoreRecyclerOptions);
    mAdapter.startListening();
    mRecycler.setAdapter(mAdapter);

    query.orderBy("material")
            .startAt(s).endAt(s + "~")
            .addSnapshotListener(new EventListener<QuerySnapshot>() {
              @Override
              public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                  // Manejar cualquier error aquí
                  return;
                }
                // Verificar si no se encontraron resultados
                if (queryDocumentSnapshots != null && queryDocumentSnapshots.isEmpty()) {
                  showToast("No se encontró el código digitado.");
                }
              }
            });
  }
  private void showToast(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }
}