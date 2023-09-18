package model.entities;

import java.sql.Date;

public class PacoteView {
    private Integer idPacote;
    private String func;
    private String hotel;
    private Double valor;
    private Date checkin;
    private Date checkout;

    public PacoteView(int idPacote, String func, String hotel, Double valor, Date checkin, Date checkout) {
        this.idPacote = idPacote;
        this.func = func;
        this.hotel = hotel;
        this.valor = valor;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public PacoteView() {
    }

    public Integer getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Integer idPacote) {
        this.idPacote = idPacote;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

}
