package F0RDUX.api.controllers;

import F0RDUX.api.models.Usuario;
import org.springframework.web.bind.annotation.*;
import F0RDUX.api.repositories.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api", method = { RequestMethod.GET, RequestMethod.POST })
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository=usuarioRepository;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAll()
    {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios/create")
    public Usuario create(Usuario usuario)
    {
        usuarioRepository.save(usuario);
        return usuario;
    }

    @DeleteMapping("/usuarios/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        usuarioRepository.deleteById(id);
    }
}
