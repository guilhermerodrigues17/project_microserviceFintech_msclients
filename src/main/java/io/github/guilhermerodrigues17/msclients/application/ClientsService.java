package io.github.guilhermerodrigues17.msclients.application;

import io.github.guilhermerodrigues17.msclients.domain.Client;
import io.github.guilhermerodrigues17.msclients.infra.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientsService {

    private final ClientsRepository repository;

    @Transactional
    public Client save(Client client) {
        return repository.save(client);
    }

    public Optional<Client> getByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
