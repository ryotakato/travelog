package travelog.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import travelog.model.Tag;

public class TagServiceTest extends AppEngineTestCase {

    private TagService service = new TagService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
    
    @Test
    public void getRootCategories() throws Exception {
        List<Tag> rootCategories = service.getRootCategories();
        assertThat(rootCategories.size(), is(notNullValue()));
    }
}
