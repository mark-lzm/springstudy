package net.litchi.spring.ioc.service.impl;

import net.litchi.spring.ioc.dao.AccountDao;
import net.litchi.spring.ioc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 14:56
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    /**
     * 事务的一致性与原子性
     * @param in
     * @param out
     * @param money
     */
//    @Transactional(propagation = Propagation.REQUIRED ,isolation = Isolation.READ_UNCOMMITTED ,rollbackFor = ,noRollbackFor = )
    @Override
    public void transferTx(int in, int out, double money) {
        accountDao.addMoney(in, money);
        int x = 1 / 0;
        accountDao.decreaseMoney(out, money);
    }

}
