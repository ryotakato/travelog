package travelog.model;

import java.io.Serializable;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.Sort;

import travelog.meta.TagEntryMeta;
import travelog.meta.TagMeta;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.SortDirection;

@Model(schemaVersion = 1)
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private String name;
    
    private ModelRef<Tag> parentTagRef = new ModelRef<Tag>(Tag.class);
    
    @Attribute(persistent = false)
    private InverseModelListRef<Tag, Tag> childrenTagRef
    = new InverseModelListRef<Tag, Tag>(
            Tag.class, TagMeta.get().parentTagRef.getName(), 
            this, new Sort(TagMeta.get().name, SortDirection.ASCENDING));
    
    @Attribute(persistent = false)
    private InverseModelListRef<TagEntry, Tag> tagEntryListRef
    = new InverseModelListRef<TagEntry, Tag>(TagEntry.class, TagEntryMeta.get().tagsRef.getName(), this);
    

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
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ModelRef<Tag> getParentTagRef() {
        return this.parentTagRef;
    }
    
    public InverseModelListRef<Tag, Tag> getChildrenTagRef() {
        return this.childrenTagRef;
    }
    
    public InverseModelListRef<TagEntry, Tag> getTagEntryListRef() {
        return this.tagEntryListRef;
    }
    
    
    public static Tag getTag(String tagName) {
        TagMeta meta = TagMeta.get();
        Tag tag = Datastore.query(meta)
                    .filter(meta.name.equal(tagName))
                    .asSingle();
        return tag;
    }
    
    public static List<Tag> getTagList(String searchText) {
        TagMeta meta = TagMeta.get();
        return Datastore.query(meta)
                // TODO startWiths ? or greaterThanOrEqual ? & limit count ?
                .filter(meta.name.greaterThanOrEqual(searchText))
                .sort(meta.name.asc)
                .asList();
    }
    
    public static List<Tag> getRootCategoryList() {
        TagMeta meta = TagMeta.get();
        return Datastore.query(meta)
                .filter(meta.parentTagRef.equal(null))
                .sort(meta.name.asc)
                .asList();
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
        Tag other = (Tag) obj;
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
