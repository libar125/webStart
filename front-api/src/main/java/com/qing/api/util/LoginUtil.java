package com.qing.api.util;


import com.qing.api.entity.MemberEntity;
import com.qing.common.utils.JwtUtil;
import com.qing.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class LoginUtil {



    public Map<String,Long> loginMap;

    @Autowired
    RedisUtils redisUtils;


    public String userLogin(MemberEntity member){
        String token = JwtUtil.createToken(member.getId(),member.getPhone());
        redisUtils.set(token,member.getId(),3600*24);
        return token;
    }


    /**
     * 验证token是否有效
     * @param token
     * @return
     */
    public boolean checkUserLogin(String token) {
        Long memberId = redisUtils.getObject(token, Long.class);
        if (memberId == null){
            return false;
        }

       MemberEntity memberEntity = null;

        if (null == memberEntity) {
            return false;
        }
        return true;
    }
}
