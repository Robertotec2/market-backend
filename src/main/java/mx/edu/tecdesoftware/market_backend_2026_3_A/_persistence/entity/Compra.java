package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "estado")
    private String estado;

    //Me falto el comit

    @ManyToOne
    @JoinColumn( name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente ;

    //una compra tiene muchos productos
    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> productos;

}