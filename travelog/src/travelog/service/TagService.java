package travelog.service;

import java.util.List;

import travelog.meta.TagMeta;
import travelog.model.Tag;


public class TagService {
    
    private TagMeta meta = new TagMeta();

    public List<Tag> getTagList(String searchText) {
        return Tag.getTagList(searchText);
    }
}
