package xwan.ood.design.twitter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xwan on 3/3/17.
 */
public class User {
    private int userId;
    private String userName;
    private Set<Integer> followed;
    private Tweet tweetHead;

    public User(int userId) {
        this.userId = userId;
        followed = new HashSet<>();
        followed.add(userId);
        tweetHead = null;
    }


}
