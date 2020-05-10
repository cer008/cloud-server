package com.example.eurekaauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.eurekaauth.common.CommonResult;
import com.example.eurekaauth.entity.AuthUser;
import com.example.eurekaauth.mapper.AuthUserMapper;
import com.example.eurekaauth.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xujin
 * @since 2020-05-10
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService
{
    @Autowired
    private AuthUserMapper authUserMapper;

    public CommonResult add(AuthUser authUser){
        List<AuthUser> authUsers = authUserMapper.selectList(new QueryWrapper<AuthUser>().lambda().eq(AuthUser::getId, 1));
        authUserMapper.selectOne(new QueryWrapper<AuthUser>().lambda().eq(AuthUser::getId, 1));
        AuthUser a = new AuthUser();
        return new CommonResult().success(authUsers);
    }
}
