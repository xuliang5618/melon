package sdu.gaming.melon.user.dao;

import org.springframework.stereotype.Repository;
import sdu.gaming.melon.api.domain.Account;

import java.util.Map;

/**
 * 帐号Dao
 *
 * @author xuliang
 */
@Repository("accountDao")
public interface IAccountDao {
    /**
     * 添加用户
     *
     * @param account
     */
    void addAccount(Account account);

    /**
     * 根据用户id获取用户
     *
     * @param userId
     * @return
     */
    Account getAccountByUserId(Long userId);

    /**
     * 根据accountNum获取用户
     *
     * @param accountNum
     * @return
     */
    Account getAccountByAccountNum(Long accountNum);

    /**
     * 根据用户名获取用户
     *
     * @param accountName
     * @return
     */
    Account getAccountByAccountName(String accountName);

    /**
     * 根据手机号获取用户
     *
     * @param phone
     * @return
     */
    Account getAccountByPhone(String phone);

    /**
     * 根据用户id获取用户
     *
     * @param email
     * @return
     */
    Account getAccountByEmail(String email);

    /**
     * 查询账户是否存在
     *
     * @param account
     * @return
     */
    Account getAccount(Map<String, Object> account);

}
