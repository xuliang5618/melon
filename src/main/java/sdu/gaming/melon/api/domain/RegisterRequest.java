package sdu.gaming.melon.api.domain;

import sdu.gaming.melon.common.domain.ServiceRequest;
import sdu.gaming.melon.common.exception.KiwifruitException;

/**
 * 注册接口请求体
 *
 * @author xuliang
 */
public class RegisterRequest extends ServiceRequest{
    @Override
    protected void validate() throws KiwifruitException {

    }

    /**
     * 用户唯一标识
     */
    private Long userId;

    /**
     * 帐号名
     */
    private String accountName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
