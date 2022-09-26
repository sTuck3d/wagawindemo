package de.floschi.wagawindemo.children.service;

import de.floschi.wagawindemo.shared.logging.LogMethod;
import de.floschi.wagawindemo.children.data.mapper.ChildDtoMapper;
import de.floschi.wagawindemo.children.data.response.ChildInfoResponse;
import de.floschi.wagawindemo.children.db.dao.ChildDao;
import de.floschi.wagawindemo.children.db.entity.Child;
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

    @Transactional
    @Cacheable(
            value = "childInfoCache",
            key = "#id")
    @LogMethod
    public ChildInfoResponse loadChildInfo(Long id) {
        Optional<Child> child = childDao.findById(id);
        return child.map(c -> childDtoMapper.childToChildInfoResponse(c))
                .orElseThrow(() -> new IllegalArgumentException("No child with id {} found"));
    }


}
