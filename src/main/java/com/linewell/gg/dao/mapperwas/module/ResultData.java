package com.linewell.gg.dao.mapperwas.module;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 返回数据格式
 */
public class ResultData implements Map, Cloneable, Serializable {

	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	private static final String CODE_KEY = "code";

	private static final String MESSAGE_KEY = "message";

	private final Map map;

	public ResultData() {
		map = new HashMap(DEFAULT_INITIAL_CAPACITY);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		return map.get(key);
	}

	public Object put(String key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object put(Object key, Object value) {
		return put((String) key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void putAll(Map m) {
		map.putAll(m);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set keySet() {
		return map.keySet();
	}

	@Override
	public Collection values() {
		return map.values();
	}

	@Override
	public Set entrySet() {
		return map.entrySet();
	}

	public int getCode() {
		Object value = get(CODE_KEY);
		return TypeUtils.castToInt(value);
	}

	public void setCode(int code) {
		put(CODE_KEY, code);
	}

	public String getMessage() {
		Object value = get(MESSAGE_KEY);
		if (value == null)
			return null;
		else
			return value.toString();
	}

	public void setMessage(String message) {
		put(MESSAGE_KEY, message);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(map);
	}

}
