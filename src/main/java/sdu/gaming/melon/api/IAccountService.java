package sdu.gaming.melon.api;

import sdu.gaming.melon.api.domain.AuthenticateRequest;
import sdu.gaming.melon.api.domain.AuthenticateResponse;
import sdu.gaming.melon.api.domain.RegisterRequest;
import sdu.gaming.melon.api.domain.RegisterResponse;

/**
 * 账户相关业务
 *
 * @author xuliang
 */
public interface IAccountService {

    /**
     * 注册 返回AccountNum
     *
     * @param registerRequest
     * @return RegisterResponse
     */
    RegisterResponse register(RegisterRequest registerRequest);

    /**
     * 登录，支持登录号/自定义/手机号/邮箱 登录
     * 登录号/自定义/手机号/邮箱 都传入，取最前面的鉴权
     *
     * @param authenticateRequest
     * @return
     */
    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);


    /**
     * 查询帐号是否存在
     *
     * @return
     */
    Boolean queryAccountExist(String accountName, String phone, String email, Integer accountNum);
}
