package dk.bringlarsen.bportal.api.converters.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime time) {
        if(time == null) {
            return null;
        }
        return Timestamp.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp time) {
        if(time == null) {
            return null;
        }
        return LocalDateTime.ofInstant(time.toInstant(), ZoneId.systemDefault());
    }
}