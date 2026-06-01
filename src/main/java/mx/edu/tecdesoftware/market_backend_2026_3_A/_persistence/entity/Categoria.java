package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id_categoria")
    private int idCategoria;


    private String descripcion;

    private Boolean estado;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy = "categoria ")
    private List<Producto > productos;
}
