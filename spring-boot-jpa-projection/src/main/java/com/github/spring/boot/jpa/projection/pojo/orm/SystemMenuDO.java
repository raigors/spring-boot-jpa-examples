package com.github.spring.boot.jpa.projection.pojo.orm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.spring.boot.jpa.common.pojo.orm.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

import static com.github.spring.boot.jpa.projection.pojo.common.SystemMenuConstant.CODE;
import static com.github.spring.boot.jpa.projection.pojo.common.SystemMenuConstant.ID;
import static com.github.spring.boot.jpa.projection.pojo.common.SystemMenuConstant.PARENT_MENU;
import static com.github.spring.boot.jpa.projection.pojo.common.SystemMenuConstant.PARENT_MENU_ID;
import static com.github.spring.boot.jpa.projection.pojo.common.SystemMenuConstant.SYSTEM_MENU;

/**
 * TODO
 * <p>
 * create in 2021/2/26 9:13 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SYSTEM_MENU, uniqueConstraints = {@UniqueConstraint(columnNames = {CODE}, name = "uk_code")})
public class SystemMenuDO extends BaseEntity {

    private static final long serialVersionUID = -406980223206898872L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) COMMENT '资源名称'")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) COMMENT '资源唯一名称'")
    private String code;

    @Column(nullable = false, columnDefinition = "INT(1) DEFAULT 0 COMMENT '菜单优先级'")
    private Integer priority;

    @Column(name = PARENT_MENU_ID, insertable = false, updatable = false, columnDefinition = "BIGINT COMMENT '父资源的ID'")
    private Long parentMenuId;

    @ManyToOne(targetEntity = SystemMenuDO.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = PARENT_MENU_ID, referencedColumnName = ID)
    @JsonBackReference
    private SystemMenuDO parentMenu;

    @OrderBy("priority ASC")
    @OneToMany(mappedBy = PARENT_MENU, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SystemMenuDO> childMenus;
}
