package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.mapper.ChildDtoMapper;
import de.floschi.wagawindemo.family.data.response.ChildInfoResponse;
import de.floschi.wagawindemo.family.db.dao.ChildDao;
import de.floschi.wagawindemo.family.db.entity.Child;
import de.floschi.wagawindemo.family.logging.LogMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ChildInfoService {
    @Autowired
    private ChildDao childDao;

    @Autowired
    private ChildDtoMapper childDtoMapper;

    @LogMethod
    @Transactional
    @Cacheable(
            value = "childInfoCache",
            key = "#id")
    public ChildInfoResponse loadChildInfo(Long id) {
        Optional<Child> child = childDao.findById(id);
        return child.map(c -> childDtoMapper.childToChildInfoResponse(c))
                .orElseThrow(() -> new IllegalArgumentException("No child with id {} found"));
    }


}
