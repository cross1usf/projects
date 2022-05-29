package cross1usf.firstproject.mappers;

import cross1usf.firstproject.dto.CommentsDto;
import cross1usf.firstproject.model.PostComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentsMapper {

    CommentsDto mapToDto(PostComment postComment);

}
