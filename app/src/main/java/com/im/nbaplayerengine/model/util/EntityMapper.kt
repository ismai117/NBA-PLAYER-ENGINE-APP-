package com.im.nbaplayerengine.model.util

interface EntityMapper<Entity,DomainModel> {

    fun toDomainModel(entity: Entity): DomainModel

    fun fromDomainModel(cacheEntity: DomainModel): Entity

}