package guru.sprintframework.spring5webapp.repositories;

import guru.sprintframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
