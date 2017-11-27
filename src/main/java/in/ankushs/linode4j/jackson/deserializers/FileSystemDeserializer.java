package in.ankushs.linode4j.jackson.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.model.enums.FileSystem;

import java.io.IOException;

/**
 * Created by ankushsharma on 27/11/17.
 */
public class FileSystemDeserializer extends JsonDeserializer<FileSystem> {

    @Override
    public FileSystem deserialize(
            final JsonParser jsonParser,
            final DeserializationContext ctxt
    )
    throws IOException
    {
        return FileSystem.from(jsonParser.getText());
    }

}