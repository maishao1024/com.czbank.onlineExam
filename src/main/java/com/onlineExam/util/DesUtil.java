package com.onlineExam.util;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.SecureRandom;

public class DesUtil {

    private static String KEY = "czbank";

    private static String CHARSET = "UTF-8";

    private static byte[] CODES = new byte[256];

    static {
        for (int i = 0; i < 256; i++)
            CODES[i] = -1;
        for (int i = 'A'; i <= 'Z'; i++)
            CODES[i] = (byte) (i - 'A');
        for (int i = 'a'; i <= 'z'; i++)
            CODES[i] = (byte) (26 + i - 'a');
        for (int i = '0'; i <= '9'; i++)
            CODES[i] = (byte) (52 + i - '0');
        CODES['+'] = 62;
        CODES['/'] = 63;
    }

    public static String enCode(String info){
        try {
            return execute(info, Cipher.ENCRYPT_MODE);
        }catch (Exception e){
            return null;
        }
    }

    public static String deCode(String info){
        try {
            return execute(info, Cipher.DECRYPT_MODE);
        }catch (Exception e){
            return null;
        }
    }

    private static String execute(String info,Integer mode) throws Exception{
        byte[] data = info.getBytes(CHARSET);
        byte[] secret = KEY.getBytes(CHARSET);
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(secret);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(secureRandom);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(mode,keyGenerator.generateKey());
        if (mode == Cipher.ENCRYPT_MODE ) {
            return new String(Base64Utils.encode(cipher.doFinal(data)));
        }else {
            return new String(cipher.doFinal(decode(info.toCharArray())));
        }
    }

     private static byte[] decode(char[] data) {
        int len = ((data.length + 3) / 4) * 3;
        if (data.length > 0 && data[data.length - 1] == '=')
            --len;
        if (data.length > 1 && data[data.length - 2] == '=')
            --len;
        byte[] out = new byte[len];
        int shift = 0;
        int accum = 0;
        int index = 0;
        for (int ix = 0; ix < data.length; ix++) {
            int value = CODES[data[ix] & 0xFF];
            if (value >= 0) {
                accum <<= 6;
                shift += 6;
                accum |= value;
                if (shift >= 8) {
                    shift -= 8;
                    out[index++] = (byte) ((accum >> shift) & 0xff);
                }
            }
        }
        if (index != out.length)
            throw new Error("解析超过限制");
        return out;
    }


}
