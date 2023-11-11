package com.example.arcasparesv21.Etiquetadoras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.arcasparesv21.Etiquetadoras.AdapterElementEtiq.AdapterElementEtiq;
import com.example.arcasparesv21.Etiquetadoras.ModelElementEtiq.ModelElementEtiq;
import com.example.arcasparesv21.MainActivity;
import com.example.arcasparesv21.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Activity_Elements extends AppCompatActivity {
  private Window window;
  private ProgressBar progressBar;
  private RecyclerView recyclerViewElements;
  private LinearLayout linearLayout;
  private ImageView ReturnActivity;
  private TextView txtNameEtiq;
  private String NameEtiq;
  private DatabaseReference myDatabaseElements;
  private AdapterElementEtiq mAdapter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_elements);
    progressBar = findViewById(R.id.progressBar_elements);
    ReturnActivity = findViewById(R.id.returnMain1);
    linearLayout = findViewById(R.id.LinearLayout_act_elements);
    txtNameEtiq = findViewById(R.id.txtNameEtiq);
    /////////////

    recyclerViewElements = findViewById(R.id.recyclerViewElement);
    recyclerViewElements = findViewById(R.id.recyclerViewElement);
    recyclerViewElements.setHasFixedSize(true);
    recyclerViewElements.setLayoutManager(new LinearLayoutManager(this));
    ////////////////////
    NameEtiq = getIntent().getStringExtra("Etiq");
    SetTypeActivity(NameEtiq);
  }

  private void SetTypeActivity(String s) {
    txtNameEtiq.setText("Etiquetadora " + s);
    if(Objects.equals(s,"Krones")) {
      ReadDatabaseElement("1S3k3pF3FiA-dTP3iJs38cjIazm-pQfW69hs07byxGiU","ElementosKrones");
      linearLayout.setBackgroundColor(android.graphics.Color.parseColor("#032995"));
      ReturnActivity.setBackgroundColor(android.graphics.Color.parseColor("#032995"));
      this.window = getWindow();
      window.setStatusBarColor(Color.parseColor("#032995"));
    }
    else if(Objects.equals(s, "Sidel")){
      ReadDatabaseElement("1YdkXTpW5LTI9G5GDJprxVgV79q7jZcY1_Uz5usCU2OA","ElementosSidel");
      linearLayout.setBackgroundColor(android.graphics.Color.parseColor("#FF6B4E"));
      ReturnActivity.setBackgroundColor(android.graphics.Color.parseColor("#FF6B4E"));
      this.window = getWindow();
      window.setStatusBarColor(Color.parseColor("#FF6B4E"));
    }
  }

  public void ReturnMainActivity(View view) {
    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EtiquetadoraFragment()).commit();
    Intent returnMain = new Intent(Activity_Elements.this, MainActivity.class);
    startActivity(returnMain);
    onBackPressed();
  }
  private void ReadDatabaseElement(String IDdrive, String s) {
    myDatabaseElements = FirebaseDatabase.getInstance().getReference().child(IDdrive).child(s);
    FirebaseRecyclerOptions<ModelElementEtiq> firebaseRecyclerOptions =
            new FirebaseRecyclerOptions.Builder<ModelElementEtiq>().setQuery(myDatabaseElements, ModelElementEtiq.class).build();
    mAdapter = new AdapterElementEtiq(firebaseRecyclerOptions, NameEtiq,progressBar,linearLayout); //NameEtiq para enviar el tipo de eetiquetadora
    mAdapter.startListening();
    recyclerViewElements.setAdapter(mAdapter);
  }
}