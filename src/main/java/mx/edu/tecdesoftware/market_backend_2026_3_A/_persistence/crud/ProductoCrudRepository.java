package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.crud;


import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //Query Method
    /*
     * Select*
     * From categorias
     * Where id_categoria=?
     * Order by nombre ASC
     */
    List findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional <List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, Boolean estado);

    Boolean estado(Boolean estado);

    Producto idProducto(Integer idProducto);
}
