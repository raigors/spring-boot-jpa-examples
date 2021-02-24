package com.github.spring.boot.jpa.event.listener;

import com.github.spring.boot.jpa.event.pojo.orm.UserInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 监听器
 * <p>
 * create in 2021/2/24 4:04 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
@SuppressWarnings("unused")
public class UserInfoListener {

    @EventListener
    public void userInfoSave1(@NotNull UserInfoDO userInfo) {
        log.error("userInfoSave1-username:{}", userInfo.getId());
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void userInfoSave2(@NotNull UserInfoDO userInfo) {
        log.error("userInfoSave2-username:{}", userInfo.getId());
    }

}
