package com.lpx.shiro.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.lpx.shiro.model.SysUser;

/**
 * @ClassName PasswordHelper
 * @Description 密码加密方法
 * @author 李平新
 * @date 2017年3月20日 上午9:54:31
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator numberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";  //算法名称
    private final int hashInterations = 2;
    
    public void encryptPassword(SysUser user) {
        user.setSalt(numberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName, 
                user.getPassword(), 
                ByteSource.Util.bytes(user.getCredentialsSalt()), hashInterations).toHex();
        user.setPassword(newPassword);
    }
    
}
