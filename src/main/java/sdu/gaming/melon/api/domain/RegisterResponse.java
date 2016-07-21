package sdu.gaming.melon.api.domain;

import sdu.gaming.melon.common.domain.ServiceResponse;

/**
 * 注册接口响应体
 *
 * @author xuliang
 */
public class RegisterResponse extends ServiceResponse{
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account accountNum) {
        this.account = account;
    }
}
