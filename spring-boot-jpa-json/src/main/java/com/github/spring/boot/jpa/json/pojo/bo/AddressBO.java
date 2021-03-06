package com.github.spring.boot.jpa.json.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * TODO
 * <p>
 * create in 2021/2/26 2:50 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBO implements Serializable {

    private static final long serialVersionUID = 8330351916838251803L;

    private String name;

    private String path;

}
