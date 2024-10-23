package com.dl.controller;

import com.dl.pojo.Article;
import com.dl.pojo.PageBean;
import com.dl.pojo.Result;
import com.dl.service.ArticleService;
import com.dl.utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
   @PostMapping
    public Result add(@RequestBody @Validated Article article){
       articleService.add(article);
       return Result.success();
   }
   @GetMapping
   public Result<PageBean<Article>> list(Integer pageNum,
                                         Integer pageSize,
                                         @RequestParam(required = false) Integer categoryId,
                                         @RequestParam(required = false) String state){

       PageBean<Article> pageBean = articleService.list(pageNum, pageSize, categoryId,state);
       return Result.success(pageBean);
   }

   @GetMapping("/detail")
    public Result<Article> detail(@RequestParam @Validated Integer id){
       Article article = articleService.findById(id);
       return Result.success(article);
   }

   @PutMapping
    public Result update(@RequestBody @Validated Article article){
       articleService.update(article);
       return Result.success();
   }

   @DeleteMapping
    public Result delete(@RequestParam Integer id){
       Article article = articleService.findById(id);
       if (article == null){
           return Result.error("该文章不存在");
       }
       articleService.delete(id);
       return Result.success();
   }
}
