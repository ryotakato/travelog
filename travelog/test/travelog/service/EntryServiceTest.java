package travelog.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EntryServiceTest extends AppEngineTestCase {

    private EntryService service = new EntryService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
