package com.github.spring.boot.jpa.switching.table.pojo.index;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.spring.boot.jpa.switching.table.pojo.common.UserInfoConstant.TB_USER_INFO_INDEX;

/**
 * TODO
 * <p>
 * create in 2021/3/4 10:55 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service("index")
public class UserTableService {

    @Resource
    private ObjectProvider<HttpServletRequest> provider;

    public String getName() {
        return index();
    }

    private String index() {
        AtomicReference<String> reference = new AtomicReference<>("tb_user_info_default");
        provider.ifAvailable(httpServletRequest -> {
            Object index = httpServletRequest.getAttribute(TB_USER_INFO_INDEX);
            if (ObjectUtils.isNotEmpty(index)) {
                reference.set((String) index);
            }
        });
        String index = reference.get();
        log.info("索引名:" + index);
        return index;
    }

}
