package com.example.arcasparesv21.Llenadoras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.arcasparesv21.Etiquetadoras.Activity_Elements;
import com.example.arcasparesv21.Etiquetadoras.AdapterElementEtiq.AdapterElementEtiq;
import com.example.arcasparesv21.Etiquetadoras.ModelElementEtiq.ModelElementEtiq;
import com.example.arcasparesv21.Llenadoras.AdapterElementLlenad.AdapterElementLlenad;
import com.example.arcasparesv21.Llenadoras.ModelElementLlenad.ModelElementLlenad;
import com.example.arcasparesv21.MainActivity;
import com.example.arcasparesv21.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Llenadora_element extends AppCompatActivity {
  private Window window;
  private ProgressBar progressBar;
  private RecyclerView recyclerViewElements;
  private LinearLayout linearLayout;
  private ImageView ReturnActivity;
  private TextView txtNameEtiq;
  private String NameLlenad;
  private DatabaseReference myDatabaseElements;
  private AdapterElementLlenad mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_llenadora_element);
    progressBar = findViewById(R.id.progressBar_elements);
    ReturnActivity = findViewById(R.id.returnMain1);
    linearLayout = findViewById(R.id.LinearLayout_act_elements);
    txtNameEtiq = findViewById(R.id.txtNameLlenad);
    /////////////

    recyclerViewElements = findViewById(R.id.recyclerViewElement);
    recyclerViewElements = findViewById(R.id.recyclerViewElement);
    recyclerViewElements.setHasFixedSize(true);
    recyclerViewElements.setLayoutManager(new LinearLayoutManager(this));
    ////////////////////
    NameLlenad = getIntent().getStringExtra("Llenadora");
    SetTypeActivity(NameLlenad);
  }

  private void SetTypeActivity(String s) {
    txtNameEtiq.setText("Llenadora " + s);
    if(Objects.equals(s,"Krones")) {
      ReadDatabaseElement("1z8mRNfJQ1QjQbZxePRIgC38zjL624ADF2-DFtSUkjGg","ElementLlenadKrones");
      linearLayout.setBackgroundColor(android.graphics.Color.parseColor("#032995"));
      ReturnActivity.setBackgroundColor(android.graphics.Color.parseColor("#032995"));
      this.window = getWindow();
      window.setStatusBarColor(Color.parseColor("#032995"));
    }
    else if(Objects.equals(s, "Sidel")){
      ReadDatabaseElement("1mjT-Tc_G5MbbmwL2JUrVHuGG934K7_WuFXCxsv7R-9c","ElementLlenadSidel");
      linearLayout.setBackgroundColor(android.graphics.Color.parseColor("#FF6B4E"));
      ReturnActivity.setBackgroundColor(android.graphics.Color.parseColor("#FF6B4E"));
      this.window = getWindow();
      window.setStatusBarColor(Color.parseColor("#FF6B4E"));
    }
  }

  public void ReturnMainActivity(View view) {
    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EtiquetadoraFragment()).commit();
    Intent returnMain = new Intent(Llenadora_element.this, MainActivity.class);
    startActivity(returnMain);
    onBackPressed();
  }
  private void ReadDatabaseElement(String IDdrive, String s) {
    myDatabaseElements = FirebaseDatabase.getInstance().getReference().child(IDdrive).child(s);
    FirebaseRecyclerOptions<ModelElementLlenad> firebaseRecyclerOptions =
            new FirebaseRecyclerOptions.Builder<ModelElementLlenad>().setQuery(myDatabaseElements, ModelElementLlenad.class).build();
    mAdapter = new AdapterElementLlenad(firebaseRecyclerOptions, NameLlenad,progressBar,linearLayout); //NameEtiq para enviar el tipo de eetiquetadora
    mAdapter.startListening();
    recyclerViewElements.setAdapter(mAdapter);
  }

}