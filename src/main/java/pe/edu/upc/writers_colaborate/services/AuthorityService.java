package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.entities.Authority;

public interface AuthorityService {

    public Authority addAuthority(Authority authority);

    public Authority findByName(String authorityName);

}
