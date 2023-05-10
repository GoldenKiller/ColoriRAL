package entity.domain;

import jakarta.persistence.*;

/**
 * @author Patrizia
 */
@Entity
@IdClass(ColorePK.class)
public class Colore {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String codice;
    @Basic
    private String nome;
    @Basic
    private String hex;
    @Basic
    private String img;
    @Id
    @ManyToOne
    private Gradazione gradazione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Gradazione getGradazione() {
        return gradazione;
    }

    public void setGradazione(Gradazione gradazione) {
        this.gradazione = gradazione;
    }

}