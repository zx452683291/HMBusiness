package com.kingda.cloudplatform.util;

import java.util.Date;

/**
 * @author Constanline
 * @description
 * @date 2019/10/18
 */
public class SysUtil {
    /**
     * Id长度。
     */
    private static final Byte ID_LENGTH = 14;
    /**
     * 服务器端维护的维一ID号。
     */
    private static long currentId = 0;

    /**
     * 服务器ID号的首位字符。
     */
    private static byte serverId0 = 'Z';
    /**
     * 服务器ID号的次位字符。
     */
    private static byte serverId1 = 'Z';
    /**
     * 同步锁。
     */
    private static Object lockGetId = new Object();
    /**
     * 36进制数字表。
     */
    public static final byte[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    /**
     * 获取服务器端唯一且正增长的13位长度编号。该编号由2位服务器编号字符串和11位基于时序动态
     *生成的字符串组成。编号由26个大写字母和10个数字组成。该方法可产生唯一且正增长的id号，并
     *可保证在公元2386年前的编码长度不超过11位（另2位为服务器编号）。该方法仅保证指定服务器
     *内（前2位服务器编号）的编号唯一。如果要使用全球唯一的编号，请使用java.util.UUID。
     *
     * @return 指定服务器内唯一的id号。
     * @see java.util.UUID#randomUUID()
     * @author Constanline
     * @date 2019/10/18
     */
    public static String getId() {
        long id;
        synchronized (lockGetId) {
            if (currentId == 0) {
                currentId = (new Date()).getTime() * 10000;
            }
            id = currentId++;
        }
        return numToString(id);
    }

    /**
     * 把长整数转换为36进制的字符串并在该字符串前加上服务器编号，作为整个字符串返回。
     * @param num 需要转换的数值。
     * @return 转换后的字符串。
     * @author Constanline
     * @date 2019/10/18
     */
    private static String numToString(long num) {
        byte buf[] = new byte[ID_LENGTH], charPos = ID_LENGTH;
        long val;

        buf[0] = serverId0;
        buf[1] = serverId1;
        while ((val = num / 36) > 0) {
            buf[--charPos] = digits[(byte) (num % 36)];
            num = val;
        }
        buf[--charPos] = digits[(byte) num];
        return new String(buf);
    }
}
