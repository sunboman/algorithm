package xwan.evernote;

import java.util.List;

/**
 * Created by xwan on 3/19/17.
 */

public interface MostRecentItems {
    void add(String id);
    List<String> getMostRecentItems();
}
