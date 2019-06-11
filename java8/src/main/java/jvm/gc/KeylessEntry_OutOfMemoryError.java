package jvm.gc;

import java.util.HashMap;
import java.util.Map;

/**
 * User: fengHong
 * Date: 2019/4/20 12:41
 * <p>
 * -Xmx12m -Xms12m
 * 注释掉 equals,  Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 */

public class KeylessEntry_OutOfMemoryError {
    static class Key {
        Integer id;

        public Key(Integer id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return id != null ? id.equals(key.id) : key.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }

    public static void main(String[] args) {
        Map m = new HashMap<Key, String>();
        for (; ; ) {
            for (int i = 0; i < 1_0000; i++) {
                Key key = new Key(i);
                if (!m.containsKey(key)) {
                    m.put(key, "Num" + i);
                }
            }
        }
    }
}
