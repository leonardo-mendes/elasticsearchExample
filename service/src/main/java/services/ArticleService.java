package services;

import domains.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository repository;

    public List<Article> findAll(){
        List<Article> articles = new ArrayList<>();
        repository.findAll().forEach(p -> articles.add(p));
        return articles;
    }

    public void insertArticle (Article article){
        repository.save(article);
    }

}
