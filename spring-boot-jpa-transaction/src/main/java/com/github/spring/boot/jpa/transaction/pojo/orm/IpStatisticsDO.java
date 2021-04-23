package com.github.spring.boot.jpa.transaction.pojo.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import static com.github.spring.boot.jpa.transaction.pojo.common.UserInfoConstant.EMAIL;
import static com.github.spring.boot.jpa.transaction.pojo.common.UserInfoConstant.USERNAME;
import static com.github.spring.boot.jpa.transaction.pojo.common.UserInfoConstant.USER_INFO;

/**
 * TODO
 * <p>
 * create in 2021/4/21 10:57 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = USER_INFO,
        indexes = {@Index(columnList = EMAIL, name = "idx_email")},
        uniqueConstraints = {@UniqueConstraint(columnNames = {USERNAME}, name = "uk_username")}
)
public class IpStatisticsDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Embeddable
    static class IpKey implements Serializable {

        private Date date;

        private Long ip;



    }

}
