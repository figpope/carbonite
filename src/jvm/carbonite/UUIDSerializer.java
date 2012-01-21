package carbonite;

import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.serialize.LongSerializer;

import java.nio.ByteBuffer;
import java.util.UUID;

/** User: sritchie Date: 1/20/12 Time: 3:22 PM */
public class UUIDSerializer extends Serializer {
    @Override public void writeObjectData(ByteBuffer byteBuffer, Object o) {
        UUID uuid = (UUID) o;
        LongSerializer.put(byteBuffer, uuid.getMostSignificantBits(), false);
        LongSerializer.put(byteBuffer, uuid.getLeastSignificantBits(), false);
    }

    @Override public <T> T readObjectData(ByteBuffer byteBuffer, Class<T> tClass) {
        return (T) new UUID(LongSerializer.get(byteBuffer, false), LongSerializer.get(byteBuffer, false));
    }
}
