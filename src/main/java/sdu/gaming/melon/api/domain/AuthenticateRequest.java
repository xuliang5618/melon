package sdu.gaming.melon.api.domain;

import org.apache.commons.lang3.StringUtils;
import sdu.gaming.melon.common.constant.ResponseCode;
import sdu.gaming.melon.common.domain.ServiceRequest;
import sdu.gaming.melon.common.exception.KiwifruitException;

/**
 * 登陆接口请求体
 *
 * @author xuliang
 */
public class AuthenticateRequest extends ServiceRequest {

    @Override
    public void validate() throws KiwifruitException {
        if(this.accountNum==null
                && StringUtils.isEmpty(this.accountName)
                &&StringUtils.isEmpty(this.phone)
                &&StringUtils.isEmpty(this.email)){
            KiwifruitException.createInstance(ResponseCode.PARAMETER_NULL,"登录帐号为空");
        }
    }

    /**
     * 用户号，考虑用户号是一个比较友好的存在，故此设计
     */
    private Long accountNum;

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


    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
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
