package guru.sprintframework.spring5webapp.controllers;

import guru.sprintframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        setAuthorRepository(authorRepository);
    }

    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", getAuthorRepository().findAll());

        return "authors";
    }
}
