package ru.gadjets.comppartapp.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "part")
public class Part {
    private int partId;
    private String descriptionRu;
    private Boolean required;
    private int count;

    @Id
    @Column(name = "part_id", nullable = false, insertable = false, updatable = false)
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Basic
    @Column(name = "description_ru", nullable = false, length = 31)
    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    @Basic
    @Column(name = "required", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        if (partId != part.partId) return false;
        if (required != part.required) return false;
        if (count != part.count) return false;
        if (descriptionRu != null ? !descriptionRu.equals(part.descriptionRu) : part.descriptionRu != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Part{" +
                "partId=" + partId +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", required=" + required +
                ", count=" + count +
                '}';
    }

    @Override
    public int hashCode() {
        int result = partId;
        result = 31 * result + (descriptionRu != null ? descriptionRu.hashCode() : 0);
        result = 31 * result + (required != null ? required.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }
}
