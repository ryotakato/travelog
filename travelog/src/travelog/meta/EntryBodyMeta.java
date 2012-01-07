package travelog.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-01-07 02:41:24")
/** */
public final class EntryBodyMeta extends org.slim3.datastore.ModelMeta<travelog.model.EntryBody> {

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<travelog.model.EntryBody> content = new org.slim3.datastore.StringUnindexedAttributeMeta<travelog.model.EntryBody>(this, "content", "content");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<travelog.model.EntryBody, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<travelog.model.EntryBody, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<travelog.model.EntryBody, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<travelog.model.EntryBody, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final EntryBodyMeta slim3_singleton = new EntryBodyMeta();

    /**
     * @return the singleton
     */
    public static EntryBodyMeta get() {
       return slim3_singleton;
    }

    /** */
    public EntryBodyMeta() {
        super("EntryBody", travelog.model.EntryBody.class);
    }

    @Override
    public travelog.model.EntryBody entityToModel(com.google.appengine.api.datastore.Entity entity) {
        travelog.model.EntryBody model = new travelog.model.EntryBody();
        model.setContent(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("content")));
        model.setKey(entity.getKey());
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        travelog.model.EntryBody m = (travelog.model.EntryBody) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("content", stringToText(m.getContent()));
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        travelog.model.EntryBody m = (travelog.model.EntryBody) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        travelog.model.EntryBody m = (travelog.model.EntryBody) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        travelog.model.EntryBody m = (travelog.model.EntryBody) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        travelog.model.EntryBody m = (travelog.model.EntryBody) model;
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
        travelog.model.EntryBody m = (travelog.model.EntryBody) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getContent() != null){
            writer.setNextPropertyName("content");
            encoder0.encode(writer, m.getContent());
        }
        if(m.getEntryRef() != null){
            writer.setNextPropertyName("entryRef");
            encoder0.encode(writer, m.getEntryRef());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected travelog.model.EntryBody jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        travelog.model.EntryBody m = new travelog.model.EntryBody();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("content");
        m.setContent(decoder0.decode(reader, m.getContent()));
        reader = rootReader.newObjectReader("entryRef");
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}