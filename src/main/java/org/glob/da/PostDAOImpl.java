package org.glob.da;

import org.glob.da.pojo.Post;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author me
 */
public class PostDAOImpl extends HibernateDaoSupport implements PostDAO {

    public Post getPostById(Long id) {
        return (Post) getSession().get(Post.class, id);  
    }

    public void savePost(Post post) {
        getSession().save(post);
    }

    @SuppressWarnings({"unchecked"})
    public List<Post> listPosts() {
        return getSession().createQuery("select p from Post as p").list();
    }
}
