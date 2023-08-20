package F0RDUX.api.controllers;

import F0RDUX.api.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import F0RDUX.api.repositories.UsuarioRepository;

import java.util.List;

@RestController
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository=usuarioRepository;
    }

    @GetMapping("api/usuarios")
    public List<Usuario> getAll()
    {
        return usuarioRepository.findAll();
    }
}
