/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ugb.ipsl.gestioninscription.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author samba
 */
@Stateless
public class CryptoService {
    private static final String MD5_ALG_NAME="MD5";
    
    private static final String TEXT_ENCODING="UTF-8";
    
    public String md5Base64(String msg){
        try {
            MessageDigest md = MessageDigest.getInstance(MD5_ALG_NAME);
            
            byte[] md5Res=md.digest(msg.getBytes(TEXT_ENCODING));
            String hash64=Base64.getEncoder().encodeToString(md5Res);
            
            return hash64;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new IpslRuntimeException(msg);
        }
    }
    
    public String sha512(){
        return null;
    }
}
