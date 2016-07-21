package sdu.gaming.melon.user.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.gaming.melon.api.IAccountService;
import sdu.gaming.melon.api.domain.*;
import sdu.gaming.melon.common.exception.KiwifruitException;
import sdu.gaming.melon.user.dao.IAccountDao;
import sdu.gaming.melon.user.service.IIdGenerateService;

import java.util.HashMap;
import java.util.Map;

import static sdu.gaming.melon.common.exception.KiwifruitErrorType.ACCOUNT_NOT_EXIST;
import static sdu.gaming.melon.common.exception.KiwifruitErrorType.UNKNOWN_ERROR;

/**
 * 账户相关业务实现类
 *
 * @author xuliang
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public static Logger log = LogManager.getLogger(AccountServiceImpl.class.getName());

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private IIdGenerateService idGenerateService;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        try {
            //todo phone,accountName,email判重
            Account account = new Account();
            account.setUserId(idGenerateService.generateUserId());
            account.setAccountNum(idGenerateService.generateAccountNum());
            account.setAccountName(registerRequest.getAccountName());
            account.setPhone(registerRequest.getPhone());
            account.setEmail(registerRequest.getEmail());
            account.setPassword(registerRequest.getPassword());
            account.setCreateTime(System.currentTimeMillis());
            accountDao.addAccount(account);
            registerResponse.setAccount(account);
        } catch (KiwifruitException e) {
            log.error(e.getErrorMsg(), e);
            registerResponse.setErrorResponse(e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            registerResponse.setErrorResponse(KiwifruitException.createInstance(UNKNOWN_ERROR));
        }
        return registerResponse;
    }

    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest) {
        AuthenticateResponse authenticateResponse = new AuthenticateResponse();
        try {
            authenticateRequest.validate();
            Account account = null;
            if (null != authenticateRequest.getAccountNum()) {
                account = accountDao.getAccountByAccountNum(authenticateRequest.getAccountNum());
            } else if (!StringUtils.isEmpty(authenticateRequest.getAccountName())) {
                account = accountDao.getAccountByAccountName(authenticateRequest.getAccountName());
            } else if (!StringUtils.isEmpty(authenticateRequest.getPhone())) {
                account = accountDao.getAccountByPhone(authenticateRequest.getPhone());
            } else {
                account = accountDao.getAccountByEmail(authenticateRequest.getEmail());
            }
            if (null == account) {
                KiwifruitException.createInstance(ACCOUNT_NOT_EXIST);
            }
            //todo 密码校验
            authenticateResponse.setAccount(account);
        } catch (KiwifruitException e) {
            log.error(e.getErrorMsg(), e);
            authenticateResponse.setErrorResponse(e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            authenticateResponse.setErrorResponse(KiwifruitException.createInstance(UNKNOWN_ERROR));
        }
        return authenticateResponse;
    }


    @Override
    public Boolean queryAccountExist(String accountName, String phone, String email, Integer accountNum) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("accountName", accountName);
        params.put("phone", phone);
        params.put("email", email);
        params.put("accountNum", accountNum);
        Account queryAccount = accountDao.getAccount(params);
        if (null == queryAccount) {
            return false;
        } else {
            return true;
        }
    }
}
