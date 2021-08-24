package co.saimyr.bookstore.persistence.mapper;

import co.saimyr.bookstore.domain.BookstoreDomain;
import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookstoreMapperDTO {

    @Mappings({
            @Mapping(source = "isbnId", target = "isbnId"),
            @Mapping(source = "noun", target = "noun"),
            @Mapping(source = "writer", target = "writer"),
            @Mapping(source = "publisher", target = "publisher"),
            @Mapping(source = "gender", target = "gender")
    })
    BookstoreDomain toBookstoreDomain(BookstoreDTO bookstoreDTO);
    List<BookstoreDomain> toBookstoresDomains(List<BookstoreDTO> bookstoreDTOS);

    @InheritInverseConfiguration
    BookstoreDTO toBookstoreDTO(BookstoreDomain bookstoreDomain);
    List<BookstoreDTO> toBookstoreDtos(List<BookstoreDomain> bookstoreDomains);
}
