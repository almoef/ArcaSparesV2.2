package com.example.arcasparesv21.Etiquetadoras.ModelSparesEtiq;

public class ModelSparesEtiq {
  private int ID;

  private String Cantidad,CódigoSAP,DescripciónBreve,
          DescripciónExtensa,Elemento,Imagen,Marca,NombreTécnico,NúmeroDeParte,EnlaceImagen;

  public ModelSparesEtiq(){

  }
  public ModelSparesEtiq(int ID, String cantidad, String códigoSAP, String descripciónBreve, String descripciónExtensa, String elemento, String imagen, String marca, String nombreTécnico, String númeroDeParte, String enlaceImagen) {
    this.ID = ID;
    Cantidad = cantidad;
    CódigoSAP = códigoSAP;
    DescripciónBreve = descripciónBreve;
    DescripciónExtensa = descripciónExtensa;
    Elemento = elemento;
    Imagen = imagen;
    Marca = marca;
    NombreTécnico = nombreTécnico;
    NúmeroDeParte = númeroDeParte;
    EnlaceImagen = enlaceImagen;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getCantidad() {
    return Cantidad;
  }

  public void setCantidad(String cantidad) {
    Cantidad = cantidad;
  }

  public String getCódigoSAP() {
    return CódigoSAP;
  }

  public void setCódigoSAP(String códigoSAP) {
    CódigoSAP = códigoSAP;
  }

  public String getDescripciónBreve() {
    return DescripciónBreve;
  }

  public void setDescripciónBreve(String descripciónBreve) {
    DescripciónBreve = descripciónBreve;
  }

  public String getDescripciónExtensa() {
    return DescripciónExtensa;
  }

  public void setDescripciónExtensa(String descripciónExtensa) {
    DescripciónExtensa = descripciónExtensa;
  }

  public String getElemento() {
    return Elemento;
  }

  public void setElemento(String elemento) {
    Elemento = elemento;
  }

  public String getImagen() {
    return Imagen;
  }

  public void setImagen(String imagen) {
    Imagen = imagen;
  }

  public String getMarca() {
    return Marca;
  }

  public void setMarca(String marca) {
    Marca = marca;
  }

  public String getNombreTécnico() {
    return NombreTécnico;
  }

  public void setNombreTécnico(String nombreTécnico) {
    NombreTécnico = nombreTécnico;
  }

  public String getNúmeroDeParte() {
    return NúmeroDeParte;
  }

  public void setNúmeroDeParte(String númeroDeParte) {
    NúmeroDeParte = númeroDeParte;
  }

  public String getEnlaceImagen() {
    return EnlaceImagen;
  }

  public void setEnlaceImagen(String enlaceImagen) {
    EnlaceImagen = enlaceImagen;
  }
}
