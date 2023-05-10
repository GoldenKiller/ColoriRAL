package entity.domain;

import java.io.Serializable;
import java.util.Objects;

public class ColorePK implements Serializable {

    private Long id;
    private Long gradazione;

    public ColorePK() {
    }

    public ColorePK(Long id, Long gradazione) {
        this.id = id;
        this.gradazione = gradazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGradazione() {
        return gradazione;
    }

    public void setGradazione(Long gradazione) {
        this.gradazione = gradazione;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final ColorePK other = (ColorePK) obj;
        if (!java.util.Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        if (!java.util.Objects.equals(this.getGradazione(), other.getGradazione())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.getId());
        hash = 31 * hash + Objects.hashCode(this.getGradazione());
        return hash;
    }

    @Override
    public String toString() {
        return "ColorePK{" + " id=" + id + ", gradazione=" + gradazione + '}';
    }

}