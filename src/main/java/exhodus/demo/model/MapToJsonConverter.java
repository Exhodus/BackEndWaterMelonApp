package exhodus.demo.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Map;

@Converter
public class MapToJsonConverter implements AttributeConverter<Map<Integer, String>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<Integer, String> attribute) {
        if (attribute == null) return null;
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error convirtiendo mapa a JSON", e);
        }
    }

    @Override
    public Map<Integer, String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) return null;
        try {
            return objectMapper.readValue(dbData, new TypeReference<Map<Integer, String>>() {});
        } catch (Exception e) {
            throw new IllegalArgumentException("Error leyendo JSON a mapa", e);
        }
    }
}
