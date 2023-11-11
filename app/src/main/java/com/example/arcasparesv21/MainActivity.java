package com.example.arcasparesv21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;


import com.example.arcasparesv21.ActivitysFragments.LlenadorasFragment;
import com.example.arcasparesv21.CatalogoRepuestos.CatalogoFragment;
import com.example.arcasparesv21.ActivitysFragments.EtiquetadoraFragment;
import com.example.arcasparesv21.ActivitysFragments.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  private Window window;
  private Toolbar toolbar;
  private DrawerLayout drawerLayout;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    this.window = getWindow();
    window.setStatusBarColor(Color.parseColor("#FF4500"));
    toolbar = findViewById(R.id.toolbar); //Ignore red line errors
    toolbar.setTitle("Arca Iventory");
    setSupportActionBar(toolbar);
    drawerLayout = findViewById(R.id.drawer_layout);
    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
            R.string.close_nav);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
      navigationView.setCheckedItem(R.id.nav_home);
    }
  }
  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    if (item.getItemId() == R.id.nav_home){
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
      toolbar.setTitle("Arca Inventory");
    }else if(item.getItemId() == R.id.nav_catalogo){
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CatalogoFragment()).commit();
      toolbar.setTitle("Catálogo de Repuestos");
    }else if(item.getItemId() == R.id.nav_etiquetadoras){
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EtiquetadoraFragment()).commit();
      toolbar.setTitle("Etiquetadoras PET");
    }
    else if(item.getItemId() == R.id.nav_llenadoras){
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LlenadorasFragment()).commit();
    toolbar.setTitle("Llenadoras PET");
   }
    drawerLayout.closeDrawer(GravityCompat.START);
    return true;
  }
  @Override
  public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }
}