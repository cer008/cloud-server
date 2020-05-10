package com.example.eurekaauth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 
 * </p>
 *
 * @author xujin
 * @since 2020-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 小程序用户唯一标识
     */
    private String openId;

    private LocalDateTime createTime;

    @Transient
    private String code;


}
