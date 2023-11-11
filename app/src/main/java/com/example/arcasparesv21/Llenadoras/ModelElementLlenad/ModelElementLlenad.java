package com.example.arcasparesv21.Llenadoras.ModelElementLlenad;

public class ModelElementLlenad {
  private String NombreElemento;

  public ModelElementLlenad(String nombreElemento) {
    NombreElemento = nombreElemento;
  }
  public ModelElementLlenad(){

  }
  public String getNombreElemento() {
    return NombreElemento;
  }

  public void setNombreElemento(String nombreElemento) {
    NombreElemento = nombreElemento;
  }
}
