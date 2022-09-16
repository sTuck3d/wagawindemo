package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.response.ChildBicycleColorResponse;
import de.floschi.wagawindemo.family.data.response.ChildColorResponse;
import de.floschi.wagawindemo.family.data.response.ChildHairColorResponse;
import de.floschi.wagawindemo.family.db.dao.ChildRepo;
import de.floschi.wagawindemo.family.db.entity.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static de.floschi.wagawindemo.family.data.ChildType.SON;

@Service
public class ChildColorService {

    @Autowired
    private ChildRepo childRepo;

    /**
     * loads the favorite color of a child. For sons the favorite color is the bicycleColor,
     * for daugthers the haircolor.
     *
     * @param id of the hhild for which the favorite color is requested
     * @return {@link ChildBicycleColorResponse} or {@link ChildHairColorResponse}.
     */
    public ChildColorResponse loadChildFavColor(Long id) {
        return childRepo.findById(id)
                .map(this::getFavoriteColorResponse)
                .orElse(null);
    }

    private ChildColorResponse getFavoriteColorResponse(Child child) {
        var favColor = child.getFavColor();
        if (SON.equals(child.getType())) {
            return new ChildBicycleColorResponse(favColor);
        }
        return new ChildHairColorResponse(favColor);
    }

}
