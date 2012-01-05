package travelog.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.DateUtil;

import travelog.meta.EntryMeta;
import travelog.model.Entry;
import travelog.model.EntryBody;

import com.google.appengine.api.datastore.Transaction;


public class EntryService {

    private EntryMeta meta = new EntryMeta();

    public Entry postEntry(Map<String, Object> input) throws Exception {

        // 入力値をModelに設定
        Entry entry = new Entry();
        EntryBody body = new EntryBody();
        BeanUtil.copy(input, entry);
        BeanUtil.copy(input, body);

        // エンティティグループの作成
        // TODO パターンはEnum化？
        String entryId = DateUtil.toString(entry.getPostedDate(), "yyyyMMddHHmmss");
        entry.setKey(Entry.createKey(entryId));
        body.setKey(EntryBody.allocateKey(entry.getKey()));

        // 記事本文と関連付け
        entry.getBodyRef().setModel(body);

        // DB更新
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, entry, body);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return entry;
    }

    public Entry getEntry(String entryId) {
        return Entry.getEntry(entryId);
    }

    public List<Entry> getEntryList() {
        return Datastore.query(meta).sort(meta.postedDate.desc).asList();
    }
}
