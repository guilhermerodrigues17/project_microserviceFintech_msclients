package io.github.guilhermerodrigues17.msclients.application;

import io.github.guilhermerodrigues17.msclients.application.representation.ClientRequestRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientsResource {

    private final ClientsService service;

    @GetMapping
    public String status() {
        return "OK!";
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ClientRequestRepresentation representation) {
        var client = representation.toModel();
        service.save(client);

        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Object> getClientByCpf(@RequestParam String cpf) {
        var client = service.getByCpf(cpf);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }
}
