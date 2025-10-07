package pe.edu.upc.writers_colaborate.services;

import pe.edu.upc.writers_colaborate.dtos.DTOUser;
import pe.edu.upc.writers_colaborate.entities.User;

public interface UserService {

    public User findById (Long id);
    public DTOUser findByIdDTO (Long id);
    public User findByUsername(String username);

    public User addUser(DTOUser dtoUser);
    public User addUser(User user);
    //aqui se va a usar un DTO

}
