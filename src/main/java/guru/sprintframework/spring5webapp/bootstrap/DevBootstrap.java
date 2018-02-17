package guru.sprintframework.spring5webapp.bootstrap;

import guru.sprintframework.spring5webapp.model.Author;
import guru.sprintframework.spring5webapp.model.Book;
import guru.sprintframework.spring5webapp.model.Publisher;
import guru.sprintframework.spring5webapp.repositories.AuthorRepository;
import guru.sprintframework.spring5webapp.repositories.BookRepository;
import guru.sprintframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        // Publisher
        Publisher collins = new Publisher("Harper Collins", "123 Bookstreet, New York");
        Publisher worx = new Publisher("Worx", "666 Workstreet, Washington");

        publisherRepository.save(collins);
        publisherRepository.save(worx);

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", collins);
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        // noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
