package uplus.spy.api.v1;

import static org.assertj.core.api.Assertions.assertThat;

import uplus.spy.api.v1.response.AuthorResponse;
import uplus.spy.api.v1.response.PostResponse;
import uplus.spy.model.domain.Author;
import uplus.spy.model.domain.Post;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class ResponseMapperTest {

  private final ResponseMapper responseMapper = Mappers.getMapper(ResponseMapper.class);

  @Test
  void testPostMapping() {

    UUID postId = UUID.randomUUID();

    Post source =
        new Post(
            postId,
            "title",
            "content",
            Instant.now(),
            new Author("nickname"),
            Set.of("tag1", "tag2"));

    PostResponse result = responseMapper.map(source);

    PostResponse expected =
        new PostResponse(
            postId.toString(),
            "title",
            "content",
            source.createdAt(),
            new AuthorResponse("nickname"),
            Set.of("tag1", "tag2"));

    assertThat(result).isEqualTo(expected);
  }
}
