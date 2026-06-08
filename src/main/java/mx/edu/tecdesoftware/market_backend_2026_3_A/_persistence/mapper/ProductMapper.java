package mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.mapper;

import mx.edu.tecdesoftware.market_backend_2026_3_A.Domain.Product;
import mx.edu.tecdesoftware.market_backend_2026_3_A._persistence.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings; // Necesitas importar esto

@Mapper(componentModel = "spring")
public abstract class ProductMapper { // Tiene que ser abstract class

    @Mappings({ // Tiene que ser en plural para usar las llaves {}
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    public abstract Product toProduct(Producto producto); // Este método es 100% obligatorio

}