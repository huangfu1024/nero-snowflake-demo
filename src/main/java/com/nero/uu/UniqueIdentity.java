package com.nero.uu;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * 基于uuid的ID生成方案的改良版本
 * <p>
 * date : 2018/8/23
 * time : 下午8:38
 * </p>
 *
 * @author Nero
 */
public class UniqueIdentity {

    /*
     * Generate unique ID from UUID in positive space
     *
             * @return long value representing UUID
     */
    public static Long generateLongUId() {
        long val;
        do {
            final UUID uid = UUID.randomUUID();
            final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
            buffer.putLong(uid.getLeastSignificantBits());
            buffer.putLong(uid.getMostSignificantBits());
            final BigInteger bi = new BigInteger(buffer.array());
            val = bi.longValue();
        } while (val < 0);
        return val;
    }

    /**
     * Generate 13 Digits unique ID from UUID in positive space
     * @return 13 Digits long value representing UUID
     */
    public static Long get13DigitsUId() {
        Long uniqueIdentity = generateLongUId();
        String s = String.valueOf(uniqueIdentity);
        s = s.substring(0, 13);
        return Long.valueOf(s);
    }
}
