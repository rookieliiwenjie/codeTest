package com.company.shejimoshi.FlyweightDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class GlyphFactory {
    private Map<Character, Glyph> pool = new HashMap<>();

    public Glyph getCharacter(char c) {
        if (!pool.containsKey(c)) {
            pool.put(c, new CharacterGlyph(c));  // 不存在则创建并缓存
        }
        return pool.get(c);
    }

    @Override
    public String toString() {
//        for (Chapool.keySet()) {
//
//        }
        return "GlyphFactory{" +
                "pool=" + pool +
                '}';
    }
}
