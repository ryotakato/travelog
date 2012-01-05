package travelog.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import travelog.model.Comment;

public class CommentServiceTest extends AppEngineTestCase {

    private CommentService service = new CommentService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void comment() throws Exception {
//        Map<String, Object> input = new HashMap<String, Object>();
//        input.put("content", "Hello");
//        Long entryId = 1L;
//        Comment postedComment = service.postComment(input, entryId);
//        assertThat(postedComment, is(notNullValue()));
//        Comment stored = Datastore.get(Comment.class, postedComment.getKey());
//        assertThat(stored.getContent(), is("Hello"));
    }

    @Test
    public void getCommentList() throws Exception {
//        Comment comment = new Comment();
//        comment.setContent("Hello");
//        Datastore.put(comment);
//        List<Comment> commentList = service.getCommentList();
//        assertThat(commentList.size(), is(1));
//        assertThat(commentList.get(0).getContent(), is("Hello"));

    }
}
