package uplus.spy.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import uplus.spy.model.domain.Author;
import uplus.spy.model.domain.Post;
import uplus.spy.model.orm.PostEntity;
import uplus.spy.model.orm.TagEntity;
import uplus.spy.model.orm.UserEntity;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class ModelMapperTest {
  private final ModelMapper modelMapper = Mappers.getMapper(ModelMapper.class);

  @Test
  void testPostMapping() {
    UUID postId = UUID.randomUUID();
    UUID userId = UUID.randomUUID();

    UserEntity user = new UserEntity(userId, "nickname");
    PostEntity source =
        new PostEntity(
            postId,
            "title",
            "content",
            user,
            Instant.now(),
            Set.of(
                new TagEntity(UUID.randomUUID(), "tag1"),
                new TagEntity(UUID.randomUUID(), "tag2")));

    Post result = modelMapper.map(source);

    Post expected =
        new Post(
            postId,
            "title",
            "content",
            source.getCreatedAt(),
            new Author("nickname"),
            Set.of("tag1", "tag2"));

    assertThat(result).isEqualTo(expected);
  }
}
