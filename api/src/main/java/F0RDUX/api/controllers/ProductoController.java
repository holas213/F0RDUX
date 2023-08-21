package F0RDUX.api.controllers;

import F0RDUX.api.models.CategoriaProducto;
import F0RDUX.api.models.Producto;
import F0RDUX.api.repositories.ProductoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ProductoController {
    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping("/productos")
    public List<Producto> findAll()
    {
        return productoRepository.findAll();
    }

    @PostMapping("productos/create")
    public Producto create(Producto producto)
    {
        return productoRepository.save(producto);
    }
    @PutMapping("productos/actualizar")
    public Producto update(Producto actualizar)
    {
        Producto cambiar=productoRepository.getReferenceById(actualizar.getId());
        cambiar.setNombre(actualizar.getNombre());
        cambiar.setPrecio(actualizar.getPrecio());
        cambiar.setCategoriaProducto(actualizar.getCategoriaProducto());
        cambiar.setStock(actualizar.getStock());
        cambiar.setPrecio(actualizar.getPrecio());
        cambiar.setDireccionImagen(actualizar.getDireccionImagen());
        return  productoRepository.save(cambiar);
    }
    @DeleteMapping("productos/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        productoRepository.deleteById(id);
    }
}
