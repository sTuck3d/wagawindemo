package de.floschi.wagawindemo.children.service;

import de.floschi.wagawinddemo.shared.logging.LogMethod;
import de.floschi.wagawindemo.children.data.response.ChildBicycleColorResponse;
import de.floschi.wagawindemo.children.data.response.ChildColorResponse;
import de.floschi.wagawindemo.children.data.response.ChildHairColorResponse;
import de.floschi.wagawindemo.children.db.dao.ChildDao;
import de.floschi.wagawindemo.children.db.entity.Child;
import de.floschi.wagawindemo.children.db.enums.ChildType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ChildColorService {

    @Autowired
    private ChildDao childDao;

    /**
     * loads the favorite color of a child. For sons the favorite color is the bicycleColor,
     * for daughters the haircolor.
     *
     * @param id of the child for which the favorite color is requested
     * @return {@link ChildBicycleColorResponse} or {@link ChildHairColorResponse}.
     */
    @Cacheable(value = "childColorCache", key = "#id")
    @LogMethod
    public ChildColorResponse loadChildFavColor(Long id) {
        return childDao.findById(id)
                .map(this::getFavoriteColorResponse)
                .orElse(null);
    }

    private ChildColorResponse getFavoriteColorResponse(Child child) {
        var favColor = child.getFavColor();
        if (ChildType.SON.equals(child.getType())) {
            return new ChildBicycleColorResponse(favColor);
        }
        return new ChildHairColorResponse(favColor);
    }

}
