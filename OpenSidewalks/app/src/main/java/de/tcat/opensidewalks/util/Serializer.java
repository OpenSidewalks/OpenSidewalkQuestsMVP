package de.tcat.opensidewalks.util;

public interface Serializer
{
	byte[] toBytes(Object object);
	<T> T toObject(byte[] bytes, Class<T> type);
}
