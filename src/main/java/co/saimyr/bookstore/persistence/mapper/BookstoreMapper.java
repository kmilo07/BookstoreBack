package co.saimyr.bookstore.persistence.mapper;

import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookstoreMapper {
    @Mappings({
            @Mapping(source = "isbn", target = "isbnId"),
            @Mapping(source = "name", target = "noun"),
            @Mapping(source = "author", target = "writer"),
            @Mapping(source = "publisher", target = "publisher"),
            @Mapping(source = "genre", target = "gender")
    })
    BookstoreDTO toBookstoreDTO(BookEntity bookEntity);
    List<BookstoreDTO> toBookstoresDTO(List<BookEntity> bookEntities);

    @InheritInverseConfiguration
    BookEntity toBookstore(BookstoreDTO bookstoreDTO);

}
