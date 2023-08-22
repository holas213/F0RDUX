package F0RDUX.api.controllers;

import F0RDUX.api.models.Pedido;
import F0RDUX.api.repositories.PedidoRepository;
import F0RDUX.api.repositories.ProductoRepository;
import F0RDUX.api.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api",method = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class PedidoController {

    private PedidoRepository pedidoRepository;
    private UsuarioRepository usuarioRepository;
    private ProductoRepository productoRepository;

    public PedidoController(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;
    }

    @GetMapping("/pedidos")
    public List<Pedido> getAll()
    {
        return pedidoRepository.findAll();
    }

    @PostMapping("/pedidos/create")
    public Pedido create(Pedido pedido)
    {
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/pedidos/update")
    public Pedido update(Pedido pedido)
    {
        Pedido actualizar=pedidoRepository.getReferenceById(pedido.getId());
        actualizar.setEstado(pedido.getEstado());
        actualizar.setTotal(pedido.getTotal());
        actualizar.setIdUsuario(pedido.getIdUsuario());
        actualizar.setListaProductos(pedido.getListaProductos());
        actualizar.setTotal(pedido.getTotal());
        pedidoRepository.save(actualizar);
        return actualizar;
    }
    @DeleteMapping("/pedidos/delete/{id}")
    public void deleteById(@PathVariable Long id)
    {
        pedidoRepository.deleteById(id);
    }

}
