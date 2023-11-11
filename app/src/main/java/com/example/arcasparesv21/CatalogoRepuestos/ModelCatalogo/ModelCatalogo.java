package com.example.arcasparesv21.CatalogoRepuestos.ModelCatalogo;

public class ModelCatalogo {
  String descripcionSap,equipo,fabricanteComponente, linea, material, medidas, npFabricante, npProveedor, proveedorMaquina, textoExtendido,tipoDeMaterial,urlImagen;

  public ModelCatalogo(String descripcionSap, String equipo, String fabricanteComponente, String linea, String material, String medidas, String npFabricante, String npProveedor, String proveedorMaquina, String textoExtendido, String tipoDeMaterial, String urlImagen) {
    this.descripcionSap = descripcionSap;
    this.equipo = equipo;
    this.fabricanteComponente = fabricanteComponente;
    this.linea = linea;
    this.material = material;
    this.medidas = medidas;
    this.npFabricante = npFabricante;
    this.npProveedor = npProveedor;
    this.proveedorMaquina = proveedorMaquina;
    this.textoExtendido = textoExtendido;
    this.tipoDeMaterial = tipoDeMaterial;
    this.urlImagen = urlImagen;
  }
  public ModelCatalogo(){

  }
  public String getDescripcionSap() {
    return descripcionSap;
  }

  public void setDescripcionSap(String descripcionSap) {
    this.descripcionSap = descripcionSap;
  }

  public String getEquipo() {
    return equipo;
  }

  public void setEquipo(String equipo) {
    this.equipo = equipo;
  }

  public String getFabricanteComponente() {
    return fabricanteComponente;
  }

  public void setFabricanteComponente(String fabricanteComponente) {
    this.fabricanteComponente = fabricanteComponente;
  }

  public String getLinea() {
    return linea;
  }

  public void setLinea(String linea) {
    this.linea = linea;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getMedidas() {
    return medidas;
  }

  public void setMedidas(String medidas) {
    this.medidas = medidas;
  }

  public String getNpFabricante() {
    return npFabricante;
  }

  public void setNpFabricante(String npFabricante) {
    this.npFabricante = npFabricante;
  }

  public String getNpProveedor() {
    return npProveedor;
  }

  public void setNpProveedor(String npProveedor) {
    this.npProveedor = npProveedor;
  }

  public String getProveedorMaquina() {
    return proveedorMaquina;
  }

  public void setProveedorMaquina(String proveedorMaquina) {
    this.proveedorMaquina = proveedorMaquina;
  }

  public String getTextoExtendido() {
    return textoExtendido;
  }

  public void setTextoExtendido(String textoExtendido) {
    this.textoExtendido = textoExtendido;
  }

  public String getTipoDeMaterial() {
    return tipoDeMaterial;
  }

  public void setTipoDeMaterial(String tipoDeMaterial) {
    this.tipoDeMaterial = tipoDeMaterial;
  }

  public String getUrlImagen() {
    return urlImagen;
  }

  public void setUrlImagen(String urlImagen) {
    this.urlImagen = urlImagen;
  }
}
