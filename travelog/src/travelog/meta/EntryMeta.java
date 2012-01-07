package travelog.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-01-07 22:19:32")
/** */
public final class EntryMeta extends org.slim3.datastore.ModelMeta<travelog.model.Entry> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<travelog.model.Entry, org.slim3.datastore.ModelRef<travelog.model.EntryBody>, travelog.model.EntryBody> bodyRef = new org.slim3.datastore.ModelRefAttributeMeta<travelog.model.Entry, org.slim3.datastore.ModelRef<travelog.model.EntryBody>, travelog.model.EntryBody>(this, "bodyRef", "bodyRef", org.slim3.datastore.ModelRef.class, travelog.model.EntryBody.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<travelog.model.Entry, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<travelog.model.Entry, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<travelog.model.Entry, java.util.Date> postedDate = new org.slim3.datastore.CoreAttributeMeta<travelog.model.Entry, java.util.Date>(this, "postedDate", "postedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<travelog.model.Entry> title = new org.slim3.datastore.StringAttributeMeta<travelog.model.Entry>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<travelog.model.Entry, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<travelog.model.Entry, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final EntryMeta slim3_singleton = new EntryMeta();

    /**
     * @return the singleton
     */
    public static EntryMeta get() {
       return slim3_singleton;
    }

    /** */
    public EntryMeta() {
        super("Entry", travelog.model.Entry.class);
    }

    @Override
    public travelog.model.Entry entityToModel(com.google.appengine.api.datastore.Entity entity) {
        travelog.model.Entry model = new travelog.model.Entry();
        if (model.getBodyRef() == null) {
            throw new NullPointerException("The property(bodyRef) is null.");
        }
        model.getBodyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("bodyRef"));
        model.setKey(entity.getKey());
        model.setPostedDate((java.util.Date) entity.getProperty("postedDate"));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        travelog.model.Entry m = (travelog.model.Entry) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getBodyRef() == null) {
            throw new NullPointerException("The property(bodyRef) must not be null.");
        }
        entity.setProperty("bodyRef", m.getBodyRef().getKey());
        entity.setProperty("postedDate", m.getPostedDate());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        travelog.model.Entry m = (travelog.model.Entry) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        travelog.model.Entry m = (travelog.model.Entry) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        travelog.model.Entry m = (travelog.model.Entry) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        travelog.model.Entry m = (travelog.model.Entry) model;
        if (m.getBodyRef() == null) {
            throw new NullPointerException("The property(bodyRef) must not be null.");
        }
        m.getBodyRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        travelog.model.Entry m = (travelog.model.Entry) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        travelog.model.Entry m = (travelog.model.Entry) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getBodyRef() != null && m.getBodyRef().getKey() != null){
            writer.setNextPropertyName("bodyRef");
            encoder0.encode(writer, m.getBodyRef(), maxDepth, currentDepth);
        }
        if(m.getCommentsRef() != null){
            writer.setNextPropertyName("commentsRef");
            encoder0.encode(writer, m.getCommentsRef());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getPostedDate() != null){
            writer.setNextPropertyName("postedDate");
            encoder0.encode(writer, m.getPostedDate());
        }
        if(m.getTitle() != null){
            writer.setNextPropertyName("title");
            encoder0.encode(writer, m.getTitle());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected travelog.model.Entry jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        travelog.model.Entry m = new travelog.model.Entry();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("bodyRef");
        decoder0.decode(reader, m.getBodyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("commentsRef");
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("postedDate");
        m.setPostedDate(decoder0.decode(reader, m.getPostedDate()));
        reader = rootReader.newObjectReader("title");
        m.setTitle(decoder0.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}