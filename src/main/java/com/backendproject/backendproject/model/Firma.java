package com.backendproject.backendproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="firmaDigital")
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_firma;

    @Column(name = "tipo_firma",length = 1, nullable = false)
    private String tipo_firma;

    @Column(name = "razon_social",length = 200, nullable = false)
    private String razon_social;

    @Column(name = "representante_legal",length = 200, nullable = false)
    private String representante_legal;

    @Column(name = "empresa_acreditadora",length = 200, nullable = false)
    private String empresa_acreditadora;

    @Column(name = "fecha_emision", nullable = false)
    private Date fecha_emision;

    @Column(name = "fecha_vencimiento", nullable = false)
    private Date fecha_vencimiento;

    @Column(name = "ruta_rubrica",length = 255, nullable = false)
    private String ruta_rubrica;

    @Column(name = "certificado_digital",length = 255, nullable = false)
    private String certificado_digital;

    public Firma(){

    }

    public Firma(long id_firma, String tipo_firma, String razon_social, String representante_legal, String empresa_acreditadora, Date fecha_emision, Date fecha_vencimiento, String ruta_rubrica, String certificado_digital) {
        this.id_firma = id_firma;
        this.tipo_firma = tipo_firma;
        this.razon_social = razon_social;
        this.representante_legal = representante_legal;
        this.empresa_acreditadora = empresa_acreditadora;
        this.fecha_emision = fecha_emision;
        this.fecha_vencimiento = fecha_vencimiento;
        this.ruta_rubrica = ruta_rubrica;
        this.certificado_digital = certificado_digital;
    }

    public long getId_firma() {
        return id_firma;
    }

    public void setId_firma(long id_firma) {
        this.id_firma = id_firma;
    }

    public String getTipo_firma() {
        return tipo_firma;
    }

    public void setTipo_firma(String tipo_firma) {
        this.tipo_firma = tipo_firma;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRepresentante_legal() {
        return representante_legal;
    }

    public void setRepresentante_legal(String representante_legal) {
        this.representante_legal = representante_legal;
    }

    public String getEmpresa_acreditadora() {
        return empresa_acreditadora;
    }

    public void setEmpresa_acreditadora(String empresa_acreditadora) {
        this.empresa_acreditadora = empresa_acreditadora;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getRuta_rubrica() {
        return ruta_rubrica;
    }

    public void setRuta_rubrica(String ruta_rubrica) {
        this.ruta_rubrica = ruta_rubrica;
    }

    public String getCertificado_digital() {
        return certificado_digital;
    }

    public void setCertificado_digital(String certificado_digital) {
        this.certificado_digital = certificado_digital;
    }
}
