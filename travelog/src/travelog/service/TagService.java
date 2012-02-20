package travelog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.util.DateUtil;
import org.slim3.util.StringUtil;

import travelog.model.Tag;

import com.google.appengine.api.datastore.Transaction;


public class TagService {

    public List<Tag> getTagList(String searchText) {
        return Tag.getCategoryList(searchText);
    }

    public List<Tag> getRootCategories() {
        return Tag.getRootCategoryList();
    }

    public List<Tag> postTags(String[] tagArray, Date postedDate) throws Exception {
        
        // post category
        List<Tag> tags = new ArrayList<Tag>();
        for (String tagName : tagArray) {
            if ( ! StringUtil.isEmpty(tagName)) {
                tags.add(getOrMakeCategory(tagName));   
            }
        }
       
        // TODO Enum pattern ?
        String year = DateUtil.toString(postedDate, "yyyy");
        String month = DateUtil.toString(postedDate, "yyyyMM");
        
        // year tag
        Tag yearTag = getOrMakeTag(year, true);
        // month tag
        Tag monthTag = getOrMakeMonthTag(yearTag, month);
        
        tags.add(yearTag);
        tags.add(monthTag);

        return tags;
    }
    
    private Tag getOrMakeMonthTag(Tag yearTag, String month) throws Exception {
        
        // month tag
        Tag monthTag = Tag.getTag(month, true);
        if (monthTag == null) {
            monthTag = new Tag();
            monthTag.setName(month);
            monthTag.setPeriod(true);
            // relation year and month entity
            monthTag.getParentTagRef().setModel(yearTag);
        }
        
        Transaction tx = Datastore.beginTransaction();
        try {
            // put to DB 
            Datastore.put(tx, monthTag);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        
        return monthTag;
    }
    
    
    private Tag getOrMakeCategory(String tagName) throws Exception {
        return getOrMakeTag(tagName, false);
    }
    
    private Tag getOrMakeTag(String tagName, boolean isPeriod) throws Exception {
        
        // is tag not exist ?
        Tag postTag = Tag.getTag(tagName, isPeriod);
        if (postTag == null) {
            // put only not exist tag
            postTag = new Tag();
            postTag.setName(tagName);
            postTag.setPeriod(isPeriod);
             
            Transaction tx = Datastore.beginTransaction();
            try {
                // put to DB 
                Datastore.put(tx, postTag);
                tx.commit();
            } catch (Exception e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
        
        return postTag;
    }
}
