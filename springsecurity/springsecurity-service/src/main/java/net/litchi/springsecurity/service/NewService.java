package net.litchi.springsecurity.service;

import net.litchi.springsecurity.pojo.News;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/6 21:14
 */
public interface NewService {

    List<News> getNews();
}
