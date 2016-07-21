package sdu.gaming.melon.common.domain;

import sdu.gaming.melon.common.exception.KiwifruitException;

/**
 * service层请求类
 * 请求类定义尽量用单独字段，不包含实体类
 *
 * @author xuliang
 */
public abstract class ServiceRequest {
    abstract protected void validate() throws KiwifruitException;
}
