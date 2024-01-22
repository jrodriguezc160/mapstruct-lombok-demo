package com.cazadordigital.mapstructlombokdemo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.cazadordigital.mapstructlombokdemo.dto.GetCategory;
import com.cazadordigital.mapstructlombokdemo.entity.Category;
import com.cazadordigital.mapstructlombokdemo.repository.CategoryRepository;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

  public CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  @Mappings({
      @Mapping(source = "id", target = "categoryId"),
      @Mapping(source = "name", target = "categoryName")
  })
  GetCategory toGetCategory(Category category);

  @InheritInverseConfiguration
  Category toEntity(GetCategory getCategory);

  List<GetCategory> toGetCategoryList(List<Category> categoryList);

  List<GetCategory> toEntityList(List<GetCategory> getCategoryList);
}
