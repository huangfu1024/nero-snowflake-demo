package com.nero.uu;

import java.util.UUID;

/**
 * uuid生成
 * <p>
 * date : 2018/8/23
 * time : 下午8:28
 * </p>
 *
 * @author Nero
 */
public class UUIDTest {

    public static void main(String[] args) {

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());

        System.out.println(UniqueIdentity.generateLongUId());
        System.out.println(UniqueIdentity.get13DigitsUId());
    }
}
