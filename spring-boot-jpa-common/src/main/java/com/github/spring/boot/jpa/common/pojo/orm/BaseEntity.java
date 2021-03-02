package com.github.spring.boot.jpa.common.pojo.orm;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 所有 entity 的基础类
 * <p>
 * create in 2021/2/23 5:02 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Audited
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2179485616434241254L;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0 COMMENT '该记录是否逻辑删除'")
    protected Boolean deleted;

    @CreatedDate
    @Column(name = "create_date", columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreationTimestamp
    protected LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "last_modified_date", columnDefinition = "DATETIME COMMENT '最后更新时间'")
    protected LocalDateTime lastModifiedDate;

    @Version
    @Column(columnDefinition = "INT(11) NOT NULL DEFAULT 0 COMMENT '版本号-乐观锁'")
    protected Long version;

    @Column(columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '备注信息'")
    protected String note;

}
