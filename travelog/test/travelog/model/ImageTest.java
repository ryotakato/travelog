package travelog.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ImageTest extends AppEngineTestCase {

    private Image model = new Image();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
