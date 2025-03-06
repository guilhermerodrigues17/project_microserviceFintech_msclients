package io.github.guilhermerodrigues17.msclients.infra.repository;

import io.github.guilhermerodrigues17.msclients.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByCpf(String cpf);
}
