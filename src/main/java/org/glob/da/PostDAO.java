package org.glob.da;

import org.glob.da.pojo.Post;

import java.util.List;

/**
 * @author me
 */
public interface PostDAO {

    public Post getPostById(Long id);

    public void savePost(Post post);

    public List<Post> listPosts();

}
