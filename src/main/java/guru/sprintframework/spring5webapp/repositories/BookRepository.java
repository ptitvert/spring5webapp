package guru.sprintframework.spring5webapp.repositories;

import guru.sprintframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
