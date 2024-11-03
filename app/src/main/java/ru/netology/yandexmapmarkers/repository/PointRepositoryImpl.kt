package ru.netology.yandexmapmarkers.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.netology.yandexmapmarkers.dao.PointDbDao
import ru.netology.yandexmapmarkers.dao.PointMapEntity
import ru.netology.yandexmapmarkers.dao.toDto
import ru.netology.yandexmapmarkers.dto.PointMap
import javax.inject.Inject

class PointRepositoryImpl @Inject constructor(
    private val dao: PointDbDao,
) : PointRepository {
    override val data: Flow<List<PointMap>>
        get() = dao.getAll()
            .map(List<PointMapEntity>::toDto)
            .flowOn(Dispatchers.Default)

    override suspend fun edit(pointMap: PointMap) {

    }

    override suspend fun removeById(id: Int) {
        dao.removeById(id)
    }

    override suspend fun save(pointMap: PointMap) {
        dao.insert(PointMapEntity.fromDto(pointMap))
    }
}