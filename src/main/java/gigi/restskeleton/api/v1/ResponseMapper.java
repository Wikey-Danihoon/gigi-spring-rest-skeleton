package uplus.spy.api.v1;

import uplus.spy.api.v1.response.AuthorResponse;
import uplus.spy.api.v1.response.PostResponse;
import uplus.spy.model.domain.Author;
import uplus.spy.model.domain.Post;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

  PostResponse map(Post post);

  List<PostResponse> map(Collection<Post> post);

  AuthorResponse map(Author author);
}
