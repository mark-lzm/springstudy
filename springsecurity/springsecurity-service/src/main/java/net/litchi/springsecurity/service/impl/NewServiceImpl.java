package net.litchi.springsecurity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import net.litchi.springsecurity.mapper.NewsMapper;
import net.litchi.springsecurity.pojo.News;
import net.litchi.springsecurity.service.NewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/6 21:13
 */
@Service
@AllArgsConstructor
public class NewServiceImpl implements NewService {

    private NewsMapper newsMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<News> getNews() {

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(4);
        ids.add(56);
        ids.add(78);
        ids.add(52);
        ids.add(41);

        Example example = new Example(News.class);
        example.createCriteria().andLike("cover", "%img%").andIn("id", ids);
        example.orderBy("id").desc();

        Page<News> page = PageHelper.startPage(1, 5, true, null, null);

        List<News> news = newsMapper.selectByExample(example);
        return news;
    }

}
