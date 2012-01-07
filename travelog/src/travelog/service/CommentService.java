package travelog.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import travelog.meta.CommentMeta;
import travelog.model.Comment;
import travelog.model.Entry;

import com.google.appengine.api.datastore.Transaction;


public class CommentService {

    private CommentMeta c = new CommentMeta();

    public Comment postComment(Map<String, Object> input, String entryId) throws Exception {

        // 記事の取得
        Entry entry = Entry.getEntry(entryId);

        // コメントの作成
        Comment comment = new Comment();
        BeanUtil.copy(input, comment);

        // コメントと記事の関連付け
        comment.getModelRef().setModel(entry);

        // DB登録
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, comment);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }


        return comment;
    }


    public List<Comment> getCommentList(Entry entry) {
        return entry.getCommentsRef().getModelList();
    }
}
