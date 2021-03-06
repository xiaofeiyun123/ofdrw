package org.ofdrw.layout.element;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ofdrw.layout.Rectangle;

public class SpanTest {

    @Test
    public void split() {
        Span span = new Span("你好OFD R&W");
        Span[] split = span.split(2);
        System.out.println();
        Assertions.assertEquals(split[0].getText(), "你好");
        Assertions.assertEquals(split[1].getText(), "OFD R&W");
    }

    @Test
    public void blockSize() {
        Span span = new Span("你好OFD R&W")
                .setFontSize(10d);
        Rectangle rectangle = span.blockSize();
        Assertions.assertEquals(rectangle.getHeight(), 10);
        Assertions.assertEquals(rectangle.getWidth(), 20 + 7 * 6);
        Assertions.assertEquals( span.blockSize().getWidth(), 20 + 7 * 6);

        span.setLetterSpacing(3d);
        Assertions.assertEquals(span.blockSize().getWidth(), 20 + 7 * 6 + 9 * 3);

    }
}
