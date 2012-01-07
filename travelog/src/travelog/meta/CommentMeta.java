package travelog.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-01-07 02:41:25")
/** */
public final class CommentMeta extends org.slim3.datastore.ModelMeta<travelog.model.Comment> {

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<travelog.model.Comment> content = new org.slim3.datastore.StringUnindexedAttributeMeta<travelog.model.Comment>(this, "content", "content");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<travelog.model.Comment, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<travelog.model.Comment, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<travelog.model.Comment, org.slim3.datastore.ModelRef<travelog.model.Entry>, travelog.model.Entry> modelRef = new org.slim3.datastore.ModelRefAttributeMeta<travelog.model.Comment, org.slim3.datastore.ModelRef<travelog.model.Entry>, travelog.model.Entry>(this, "modelRef", "modelRef", org.slim3.datastore.ModelRef.class, travelog.model.Entry.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<travelog.model.Comment, java.util.Date> postedDate = new org.slim3.datastore.CoreAttributeMeta<travelog.model.Comment, java.util.Date>(this, "postedDate", "postedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<travelog.model.Comment> postedName = new org.slim3.datastore.StringAttributeMeta<travelog.model.Comment>(this, "postedName", "postedName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<travelog.model.Comment, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<travelog.model.Comment, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final CommentMeta slim3_singleton = new CommentMeta();

    /**
     * @return the singleton
     */
    public static CommentMeta get() {
       return slim3_singleton;
    }

    /** */
    public CommentMeta() {
        super("Comment", travelog.model.Comment.class);
    }

    @Override
    public travelog.model.Comment entityToModel(com.google.appengine.api.datastore.Entity entity) {
        travelog.model.Comment model = new travelog.model.Comment();
        model.setContent(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("content")));
        model.setKey(entity.getKey());
        if (model.getModelRef() == null) {
            throw new NullPointerException("The property(modelRef) is null.");
        }
        model.getModelRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("modelRef"));
        model.setPostedDate((java.util.Date) entity.getProperty("postedDate"));
        model.setPostedName((java.lang.String) entity.getProperty("postedName"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        travelog.model.Comment m = (travelog.model.Comment) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("content", stringToText(m.getContent()));
        if (m.getModelRef() == null) {
            throw new NullPointerException("The property(modelRef) must not be null.");
        }
        entity.setProperty("modelRef", m.getModelRef().getKey());
        entity.setProperty("postedDate", m.getPostedDate());
        entity.setProperty("postedName", m.getPostedName());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        travelog.model.Comment m = (travelog.model.Comment) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        travelog.model.Comment m = (travelog.model.Comment) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        travelog.model.Comment m = (travelog.model.Comment) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        travelog.model.Comment m = (travelog.model.Comment) model;
        if (m.getModelRef() == null) {
            throw new NullPointerException("The property(modelRef) must not be null.");
        }
        m.getModelRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        travelog.model.Comment m = (travelog.model.Comment) model;
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
        travelog.model.Comment m = (travelog.model.Comment) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getContent() != null){
            writer.setNextPropertyName("content");
            encoder0.encode(writer, m.getContent());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getModelRef() != null && m.getModelRef().getKey() != null){
            writer.setNextPropertyName("modelRef");
            encoder0.encode(writer, m.getModelRef(), maxDepth, currentDepth);
        }
        if(m.getPostedDate() != null){
            writer.setNextPropertyName("postedDate");
            encoder0.encode(writer, m.getPostedDate());
        }
        if(m.getPostedName() != null){
            writer.setNextPropertyName("postedName");
            encoder0.encode(writer, m.getPostedName());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected travelog.model.Comment jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        travelog.model.Comment m = new travelog.model.Comment();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("content");
        m.setContent(decoder0.decode(reader, m.getContent()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("modelRef");
        decoder0.decode(reader, m.getModelRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("postedDate");
        m.setPostedDate(decoder0.decode(reader, m.getPostedDate()));
        reader = rootReader.newObjectReader("postedName");
        m.setPostedName(decoder0.decode(reader, m.getPostedName()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}