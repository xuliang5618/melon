package sdu.gaming.melon.api.domain;

import sdu.gaming.melon.common.domain.ServiceResponse;

/**
 * 登录接口响应实体类
 *
 * @author xuliang
 */
public class AuthenticateResponse extends ServiceResponse{
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account accountNum) {
        this.account = account;
    }
}
