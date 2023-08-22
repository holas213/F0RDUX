package F0RDUX.api.controllers;

import F0RDUX.api.models.Carrito;
import F0RDUX.api.repositories.CarritoRepository;
import F0RDUX.api.repositories.ProductoRepository;
import F0RDUX.api.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarritoController {
    private CarritoRepository carritoRepository;
    private UsuarioRepository usuarioRepository;
    private ProductoRepository productoRepository;

    public CarritoController(CarritoRepository carritoRepository, UsuarioRepository usuarioRepository, ProductoRepository productoRepository) {
        this.carritoRepository = carritoRepository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;

    }
    @GetMapping("/carritos")
    public List<Carrito> getAll()
    {
        return carritoRepository.findAll();
    }

    @PostMapping("/carritos/create")
    public Carrito create(Carrito carrito)
    {
        return carritoRepository.save(carrito);
    }

    @PutMapping("/carrito/update")
    public Carrito update(Carrito carrito)
    {
        Carrito actualizar=carritoRepository.getReferenceById(carrito.getId());
        actualizar.setProductos(carrito.getProductos());
        actualizar.setIdUsuario(carrito.getIdUsuario());
        actualizar.setTotal(carrito.getTotal());
        carritoRepository.save(actualizar);
        return actualizar;
    }
    @DeleteMapping("/api/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        carritoRepository.deleteById(id);
    }
}
