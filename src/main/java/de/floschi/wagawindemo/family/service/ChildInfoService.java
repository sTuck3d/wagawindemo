package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.mapper.ChildDtoMapper;
import de.floschi.wagawindemo.family.data.response.ChildInfoResponse;
import de.floschi.wagawindemo.family.db.dao.ChildRepo;
import de.floschi.wagawindemo.family.db.entity.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChildInfoService {
    @Autowired
    private ChildRepo childRepo;

    @Autowired
    private ChildDtoMapper childDtoMapper;

    public ChildInfoResponse loadChildInfo(Long id) {
        Optional<Child> child = childRepo.findById(id);
        return child.map(c -> childDtoMapper.childToChildInfoResponse(c))
                .orElseThrow(() -> new IllegalArgumentException("No child with id {} found"));
    }


}
