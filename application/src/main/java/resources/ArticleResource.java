package resources;


import domains.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.ArticleService;

import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticleResource {

    @Autowired
    ArticleService articleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void insert(@RequestBody Article articleRequest) {
        articleService.insertArticle(articleRequest);
    }

}
