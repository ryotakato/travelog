package travelog.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;

import travelog.controller.CommentController;
import travelog.model.Comment;

public class CommentControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.param("content", "Hello");
        tester.start("/travelog/comment");
        CommentController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/travelog/"));
        Comment stored = Datastore.query(Comment.class).asSingle();
        assertThat(stored, is(notNullValue()));
        assertThat(stored.getContent(), is("Hello"));
    }
}
