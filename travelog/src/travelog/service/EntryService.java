package travelog.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.DateUtil;
import org.slim3.util.StringUtil;

import travelog.meta.EntryMeta;
import travelog.model.Entry;
import travelog.model.EntryBody;
import travelog.model.Tag;
import travelog.model.TagEntry;

import com.google.appengine.api.datastore.Transaction;


public class EntryService {

    private EntryMeta meta = new EntryMeta();
    
    /**
     * 記事投稿の前の確認処理メソッド
     * @param input 入力値
     * @return タグのチェック後Map
     * @throws Exception 例外
     */
    public Map<String, Boolean> postingEntry(Map<String, Object> input) throws Exception {
        
        String[] tagArray = (String[])input.get("tagArray");

        // 並び順を保持するためにLinkedHashMap
        Map<String, Boolean> newTagArrayMap = new LinkedHashMap<String, Boolean>();
        // タグが新規かどうかチェック
        for (String tagName : tagArray) {
            if ( ! StringUtil.isEmpty(tagName)) {
                Tag tag = Tag.getCategory(tagName);
                // 新規ならtrueを格納
                newTagArrayMap.put(tagName, tag == null);
            }
        }
        
        // チェック後の値を返す
        return newTagArrayMap;
    }

    /**
     * Post entry (= Put to DB) method
     * @param input entry 
     * @param tags entry relation tags
     * @return entry after posted
     * @throws Exception throw DB Exception
     */
    public Entry postEntry(Entry entry, EntryBody body, List<Tag> tags) throws Exception {
        
        
        // make entity groop
        // TODO Enum pattern ?
        String entryId = DateUtil.toString(entry.getPostedDate(), "yyyyMMddHHmmss");
        entry.setKey(Entry.createKey(entryId));
        body.setKey(EntryBody.allocateKey(entry.getKey()));
        
        // relation tag and entry
        List<TagEntry> tagEntries = new ArrayList<TagEntry>(); 
        for (Tag tag : tags) {
            TagEntry tagEntry = new TagEntry();
            tagEntry.getEntriesRef().setModel(entry);
            tagEntry.getTagsRef().setModel(tag);
            tagEntry.setKey(Datastore.allocateId(entry.getKey(), TagEntry.class));
            tagEntries.add(tagEntry);
        }
        

        // relation entry head and entry content
        entry.getBodyRef().setModel(body);

        // put to DB
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, entry, body);
            Datastore.put(tx, tagEntries.toArray());
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return entry;
    }

    /**
     * エントリーIDからエントリーを取得するメソッド
     * @param entryId エントリーID
     * @return 該当エントリー
     */
    public Entry getEntry(String entryId) {
        return Entry.getEntry(entryId);
    }

    /**
     * 投稿された全エントリを取得するメソッド
     * @return 全エントリ（投稿日時降順）
     */
    public List<Entry> getEntryList() {
        return Datastore.query(meta).sort(meta.postedDate.desc).asList();
    }
    
    /**
     * 投稿されたエントリを取得するメソッド
     * @param recentCount 取得件数
     * @return 該当エントリ（投稿日時降順）
     */
    public List<Entry> getEntryList(int recentCount) {
        return Datastore.query(meta).sort(meta.postedDate.desc).limit(recentCount).asList();
    }
}
