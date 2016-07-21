package sdu.gaming.melon.user.service;

/**
 * @author xuliang
 */
public interface IIdGenerateService {
    /**
     * 生成userId：根据服务器节点信息，时间戳等
     *
     * @return
     */
    Long generateUserId();

    /**
     * 用户体验好即可
     *
     * @return
     */
    Long generateAccountNum();
}
