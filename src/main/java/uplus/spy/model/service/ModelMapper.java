package uplus.spy.model.service;

import uplus.spy.model.domain.Author;
import uplus.spy.model.domain.Post;
import uplus.spy.model.orm.PostEntity;
import uplus.spy.model.orm.TagEntity;
import uplus.spy.model.orm.UserEntity;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModelMapper {

  // @Mapping(target = "name", source = "nickname")
  Author map(UserEntity userEntity);

  Post map(PostEntity postEntity);

  default Set<String> map(Set<TagEntity> entities) {
    return entities.stream().map(TagEntity::getName).collect(Collectors.toSet());
  }
}
