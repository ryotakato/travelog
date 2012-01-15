package travelog.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TagEntryTest extends AppEngineTestCase {

    private TagEntry model = new TagEntry();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
