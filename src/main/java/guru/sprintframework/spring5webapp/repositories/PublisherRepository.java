package guru.sprintframework.spring5webapp.repositories;

import guru.sprintframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
