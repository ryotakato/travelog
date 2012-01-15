package travelog.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.Sort;

import travelog.meta.CommentMeta;
import travelog.meta.TagEntryMeta;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.SortDirection;

@Model(schemaVersion = 1)
public class Entry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String title;

    private Date postedDate = new Date();

    private ModelRef<EntryBody> bodyRef = new ModelRef<EntryBody>(EntryBody.class);

    @Attribute(persistent = false)
    private InverseModelListRef<Comment, Entry> commentsRef
    = new InverseModelListRef<Comment, Entry>(
            Comment.class, CommentMeta.get().modelRef.getName(),
            this, new Sort(CommentMeta.get().postedDate, SortDirection.ASCENDING));

    @Attribute(persistent = false)
    private InverseModelListRef<TagEntry, Entry> tagEntryListRef
    = new InverseModelListRef<TagEntry, Entry>(TagEntry.class, TagEntryMeta.get().entriesRef.getName(), this);
    
    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public ModelRef<EntryBody> getBodyRef() {
        return this.bodyRef;
    }

    public InverseModelListRef<Comment, Entry> getCommentsRef() {
        return this.commentsRef;
    }
    
    public InverseModelListRef<TagEntry, Entry> getTagEntryListRef() {
        return this.tagEntryListRef;
    }

    public static Key createKey(String entryId) {
        if (entryId == null) {
            throw new IllegalArgumentException("entryId is null");
        }
        return Datastore.createKey(Entry.class, entryId);
    }

    public static Entry getEntry(String entryId) {
        Entry e = null;
        Key entryKey = null;
        try {
            entryKey = Entry.createKey(entryId);
            e = Datastore.get(Entry.class, entryKey);
        } catch (IllegalArgumentException iae) {
            throw new EntityNotFoundRuntimeException(entryKey);
        }
        return e;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Entry other = (Entry) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
