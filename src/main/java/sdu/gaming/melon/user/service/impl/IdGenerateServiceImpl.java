package sdu.gaming.melon.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.gaming.melon.user.dao.IAccountDao;
import sdu.gaming.melon.user.service.IIdGenerateService;

/**
 * @author xuliang
 */
@Service("idGenerateService")
public class IdGenerateServiceImpl implements IIdGenerateService {
    private static final Long SerId = 1L;
    @Autowired
    IAccountDao accountDao;

    @Override
    public Long generateUserId() {
        return SerId * 10000000000000L + System.currentTimeMillis();
    }

    @Override
    public Long generateAccountNum() {
        Long accountNum;
        while (true) {
            accountNum = 100000000L + (long) (Math.random() * 100000000L);
            if(null==accountDao.getAccountByAccountNum(accountNum)){
                break;
            }
        }
        return accountNum;
    }
}
