package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    void stringToInteger() {
        final StringToIntegerConverter converter = new StringToIntegerConverter();
        final Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void IntegerToString() {
        final IntegerToStringConverter converter = new IntegerToStringConverter();
        final String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        final IpPortToStringConverter converter = new IpPortToStringConverter();
        final IpPort source = new IpPort("127.0.0.1", 8080);
        final String result = converter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortToString() {
        final StringToIpPortConverter converter = new StringToIpPortConverter();
        final IpPort result = converter.convert("127.0.0.1:8080");
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));

    }
}
