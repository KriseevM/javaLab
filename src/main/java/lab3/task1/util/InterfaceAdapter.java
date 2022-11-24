package lab3.task1.util;

import com.google.gson.*;
import lab3.task1.logic.IClock;

import java.lang.reflect.Type;

public class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {


    public static final String CLASS_NAME = "className";
    public static final String DATA = "data";

    @Override
    public JsonElement serialize(T o, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject root = new JsonObject();
        root.addProperty(CLASS_NAME, o.getClass().getName());
        root.add(DATA, jsonSerializationContext.serialize(o));
        return root;
    }

    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) o.get(CLASS_NAME);
        try {
            Class c = Class.forName(prim.getAsString());
            return jsonDeserializationContext.deserialize(o.get(DATA), c);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }
}
