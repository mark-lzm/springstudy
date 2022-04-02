package net.litchi.spring.ioc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 14:54
 */
@Repository
public class AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addMoney(int id, double money) {
        return jdbcTemplate.update("update account set money = money + ? where id = ?", money, id);
    }

    public int decreaseMoney(int id, double money) {
        return jdbcTemplate.update("update account set money = money - ? where id = ?", money, id);
    }
}
