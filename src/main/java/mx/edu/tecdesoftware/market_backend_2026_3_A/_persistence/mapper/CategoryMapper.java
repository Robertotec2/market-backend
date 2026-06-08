package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.mapper;

import mx.edu.tecdesoftware.market_backend_2026_3_A.Domain.Category;
import mx.edu.tecdesoftware.market_backend_2026_3_A.Domain.Product;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Producto;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Categoria; // <-- 1. Añadido el import de tu entidad Categoria
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings; // <-- 2. Añadido para poder agrupar con llaves
import org.mapstruct.InheritInverseConfiguration; // <-- 3. Añadido para la configuración inversa

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface CategoryMapper { // <-- 4. Cambiado 'class' por 'interface'
    @Mappings({ // <-- 5. Cambiado '@Mapping(' por '@Mappings({'
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    }) // <-- 6. Cambiado ')' por '})'
    Product toProduct(Producto producto);

    List<Product> toProductList(List<Producto> productos);

    @InheritInverseConfiguration // <-- 7. Corregida la primera letra a Mayúscula
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category); // <-- 8. Cambiado 'categoria' a 'Categoria' (con C mayúscula)
}