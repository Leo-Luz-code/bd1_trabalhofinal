package modelo;

import java.util.Date;

public class Transporta {
    private int idViagem;
    private Date dataViagem;
    private Date check_in;
    private double valor;
    private String meioTransporte;

    public Transporta (int idViagem, Date dataViagem, Date check_in, double valor, String meioTransporte) {
        this.idViagem = idViagem;
        this.dataViagem = dataViagem;
        this.check_in = check_in;
        this.valor = valor;
        this.meioTransporte = meioTransporte;
    }
    
    public String getMeioTransporte() {
        return meioTransporte;
    }

    public void setMeioTransporte(String meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }
    
    public Date getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(Date dataViagem) {
        this.dataViagem = dataViagem;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }
}
