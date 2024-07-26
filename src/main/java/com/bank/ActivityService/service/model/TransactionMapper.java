package com.bank.ActivityService.service.model;

import com.bank.ActivityService.model.ActivitySummary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

  TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

  @Mapping(source = "relationshipId", target = "relationshipId")
  ActivitySummary map(
      com.bank.ActivityService.service.model.ActivitySummary activitySummary);
}
