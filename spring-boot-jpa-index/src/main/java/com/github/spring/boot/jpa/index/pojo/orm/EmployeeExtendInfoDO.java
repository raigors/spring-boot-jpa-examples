//package com.github.spring.boot.jpa.index.pojo.orm;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import static com.github.spring.boot.jpa.index.pojo.common.EmployeeConstant.EMPLOYEE_EXTEND_INFO;
//
///**
// * TODO
// * <p>
// * create in 2021/5/6 5:44 下午
// *
// * @author shishaodong
// * @version 0.0.1
// */
//@Slf4j
//@Getter
//@Setter
//@Builder
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@DynamicInsert
//@DynamicUpdate
//@Entity
//@Table(name = EMPLOYEE_EXTEND_INFO)
//public class EmployeeExtendInfoDO {
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//
//    private String address;
//
//    private String mobile;
//
//    @Column(name = "employee_id", nullable = false)
//    private Long employeeId;
//
//}
