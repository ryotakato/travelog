package travelog.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.DateUtil;

import travelog.meta.CommentMeta;
import travelog.model.Comment;
import travelog.model.Entry;

import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.mail.MailService.Message;
import com.google.appengine.api.mail.MailServiceFactory;


public class CommentService {

    private CommentMeta c = new CommentMeta();

    public Comment postComment(Map<String, Object> input, String entryId) throws Exception {

        // get entry
        Entry entry = Entry.getEntry(entryId);

        // make comment object
        Comment comment = new Comment();
        BeanUtil.copy(input, comment);

        // relation of comment & entry
        comment.getModelRef().setModel(entry);

        // DB access
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, comment);
            tx.commit();
            // send mail
            sendMail(comment, entry);
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }


        return comment;
    }
    
    private final static String LF = System.getProperty("line.separator");
    
    private void sendMail(Comment c, Entry e) throws IOException {
        
        // make mail message
        StringBuilder sb = new StringBuilder();
        sb.append("記事：").append(e.getTitle()).append(LF);
        sb.append("投稿者：").append(c.getPostedName()).append(LF);
        sb.append("コメント：").append(c.getContent()).append(LF);
        // TODO Enum pattern ?
        sb.append("投稿日時：")
        .append(DateUtil.toString(c.getPostedDate(), "yyyy-MM-dd HH:mm:ss"))
        .append(LF);
        
        Message m = new Message();
        m.setSender("system@tavi-travelog.appspotmail.com");
        m.setSubject("Tavi's Travelog Comment Posted");
        m.setTextBody(sb.toString());
        // send to admin
        MailServiceFactory.getMailService().sendToAdmins(m);
    }


    public List<Comment> getCommentList(Entry entry) {
        return entry.getCommentsRef().getModelList();
    }
    
}
