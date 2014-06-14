package com.bitium10.sso.shiro;

import com.bitium10.sso.domain.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-14
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public class PasswordHelper {
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("${password.algorithmName}")
    private String algorithmName = "md5";
    @Value("${password.hashIterations}")
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }

    public boolean validatePassword(User user,String painPassword){
        String encryptPassword = new SimpleHash(
                algorithmName,
                painPassword,
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();
        return user.getPassword().equals(encryptPassword);
    }

    public static void main(String args[]){
        String salt = "f92d687c778df797a8c9d4c749627694";//randomNumberGenerator.nextBytes().toHex();
        System.out.println(salt);
        String newPassword = new SimpleHash(
                "md5",
                "admin",
                ByteSource.Util.bytes("admin"+salt),
                2).toHex();
        System.out.println(ByteSource.Util.bytes("admin"+salt));
        System.out.println(newPassword);
        System.out.println(newPassword.equals("1bb97a7793962ef95a1edcc68d842fcc"));
    }
}
