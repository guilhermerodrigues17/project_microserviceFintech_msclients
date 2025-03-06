package io.github.guilhermerodrigues17.msclients.application.representation;

import io.github.guilhermerodrigues17.msclients.domain.Client;

public record ClientRequestRepresentation(
        String cpf,
        String name,
        Integer age
) {

    public Client toModel() {
        return new Client(cpf, name, age);
    }
}
