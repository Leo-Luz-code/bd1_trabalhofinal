package model;

import java.util.Date;

public class Reservas {
    private int idReserva;
    private Date dataReserva;
    private Date check_in;
    private Date check_out;
    private double valor;

    public Reservas(int idReserva, Date dataReserva, Date check_in, Date check_out, double valor) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.check_in = check_in;
        this.check_out = check_out;
        this.valor = valor;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
