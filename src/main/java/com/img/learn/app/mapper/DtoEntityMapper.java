package com.img.learn.app.mapper;

import javax.validation.constraints.NotNull;

/**
 * This interface defines the contract for entity to dto conversion and vise versa.
 *
 * @param <K> the dto type from which entity needs to be derived
 * @param <T> the entity type which needs to converted to dto
 */
public interface DtoEntityMapper<K, T> {

  T toEntity(@NotNull final K k);

  K toDto(@NotNull final T t);
}
