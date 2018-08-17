package org.muzhe.test.bean.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import org.muzhe.test.bean.CacheParser;
import org.muzhe.test.bean.CommonCacheRegistry;
import org.muzhe.test.util.JSONUtil;

/**
 * 缓存解析器
 *
 * @author muzhe-wang on  18-8-17 下午2:24.
 */
public class DefaultCacheParser implements CacheParser {

    /**
     * 将缓存中的内容转变为一个对象
     *
     * @param cacheContent        缓存中的内容
     * @param commonCacheRegistry 缓存对象管理策略
     * @return 缓存对应的对象
     */
    @Override
    public Object parse2Model(String cacheContent, CommonCacheRegistry commonCacheRegistry) {

        return toModel(cacheContent, commonCacheRegistry.getCacheType());
    }

    private Object toModel(String cacheContent, TypeReference cacheType) {
        String typeName = cacheType.getType().getTypeName();
        if (typeName.equals(Long.class.getTypeName())) {
            return Long.parseLong(cacheContent);
        } else if (typeName.equals(Integer.class.getTypeName())) {
            return Integer.parseInt(cacheContent);
        } else if (typeName.equals(Float.class.getTypeName())) {
            return Float.parseFloat(cacheContent);
        } else if (typeName.equals(Double.class.getTypeName())) {
            return Double.parseDouble(cacheContent);
        } else if (typeName.equals(Character.class.getTypeName())) {
            return cacheContent.charAt(0);
        } else if (typeName.equals(String.class.getTypeName())) {
            return cacheContent;
        } else if (typeName.equals(Boolean.class.getTypeName())) {
            return Boolean.valueOf(cacheContent);
        }
        return JSONUtil.readValue(cacheContent, cacheType);
    }

    /**
     * 将对象转变为　cache中存放的内容
     *
     * @param cacheModel          待缓存的对象
     * @param commonCacheRegistry 缓存对象管理策略
     * @return 缓存的字符串
     */
    @Override
    public String parse2String(Object cacheModel, CommonCacheRegistry commonCacheRegistry) {

        return toCache(cacheModel, commonCacheRegistry.getCacheType());
    }

    /**
     * 将cacheModel转变为String
     *
     * @param cacheModel 缓存对象
     * @param cacheType  缓存类型
     * @return 缓存序列化的内容
     */
    private String toCache(Object cacheModel, TypeReference cacheType) {

        String typeName = cacheType.getType().getTypeName();

        if (typeName.equals(Long.class.getName()) || typeName.equals(Integer.class.getName())
                || typeName.equals(Float.class.getName())
                || typeName.equals(Double.class.getName())
                || typeName.equals(Character.class.getName())
                || typeName.equals(Boolean.class.getName())
                || typeName.equals(String.class.getName())) {
            return cacheModel.toString();
        }
        return JSONUtil.writeValueAsString(cacheModel);
    }
}
