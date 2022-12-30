package com.devgetbook.controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devgetbook.model.DevUsuario;
import com.devgetbook.model.DevUsuarioLogin;
import com.devgetbook.repository.DevUsuarioRepository;
import com.devgetbook.services.DevUsuarioServices;
import com.devgetbook.util.MediaType;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DevUsuarioController {

	  	@Autowired
	    private DevUsuarioServices service;
	    @Autowired
	    private DevUsuarioRepository repository;

	    @PostMapping(value ="/cadastrar", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML },
				produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML })
	    public ResponseEntity<DevUsuario> postUsuario(@Valid @RequestBody DevUsuario usuario) {
	        return service.cadastrarUsuario(usuario)
	            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
	            .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	    }

	    @PostMapping("/logar")
	    public ResponseEntity<DevUsuarioLogin> login(@RequestBody Optional<DevUsuarioLogin> usuarioLogin) {
	        return service.autenticarUsuario(usuarioLogin)
	            .map(resposta -> ResponseEntity.ok(resposta))
	            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	    }

	    @GetMapping("/all")
	    public ResponseEntity <List<DevUsuario>> getAll(){
	        return ResponseEntity.ok(repository.findAll());
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<DevUsuario> getById(@PathVariable Long id) {
	        return repository.findById(id)
	            .map(resposta -> ResponseEntity.ok(resposta))
	            .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/atualizar")
	    public ResponseEntity<DevUsuario> putUsuario(@Valid @RequestBody DevUsuario usuario) {
	        return service.atualizarUsuario(usuario)
	            .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }




}
