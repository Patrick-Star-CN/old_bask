package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.PersonalTasteDao;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.model.PersonalTaste;
import team.oldbask.domain.form.PersonalTasteForm;
import team.oldbask.server.PersonalTasteService;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class PersonalTasteServiceImpl implements PersonalTasteService {

    @Autowired
    PersonalTasteDao personalTasteDao;

    @Autowired
    UserDao userDao;

    @Override
    public Boolean submitPersonalTaste(PersonalTasteForm personalTastePostForm, String uid) {
        if (userDao.selectById(uid) == null) {
            return false;
        }
        PersonalTaste personalTaste = personalTasteDao.selectByUid(Integer.parseInt(uid));
        if (personalTaste == null) {
            personalTasteDao.insert(new PersonalTaste(
                    Integer.parseInt(uid),
                    personalTastePostForm.getSour(),
                    personalTastePostForm.getSweet(),
                    personalTastePostForm.getBitterness(),
                    personalTastePostForm.getSpicy(),
                    personalTastePostForm.getSalty(),
                    personalTastePostForm.getLight(),
                    personalTastePostForm.getFiveSpice(),
                    personalTastePostForm.getScallion(),
                    personalTastePostForm.getGarlic(),
                    personalTastePostForm.getMilkFragrance(),
                    personalTastePostForm.getSoySauce(),
                    personalTastePostForm.getCurry(),
                    personalTastePostForm.getCumin(),
                    personalTastePostForm.getFruity(),
                    personalTastePostForm.getVanilla(),
                    personalTastePostForm.getSweetFragrance(),
                    personalTastePostForm.getDairyAllergy(),
                    personalTastePostForm.getProteinAllergy(),
                    personalTastePostForm.getNutAllergy(),
                    personalTastePostForm.getSeafoodAllergy(),
                    personalTastePostForm.getSoyAllergy(),
                    personalTastePostForm.getWheatAllergy(),
                    personalTastePostForm.getPeanutAllergy()
            ));
        } else {
            personalTasteDao.updateByUid(new PersonalTaste(
                    Integer.parseInt(uid),
                    personalTastePostForm.getSour(),
                    personalTastePostForm.getSweet(),
                    personalTastePostForm.getBitterness(),
                    personalTastePostForm.getSpicy(),
                    personalTastePostForm.getSalty(),
                    personalTastePostForm.getLight(),
                    personalTastePostForm.getFiveSpice(),
                    personalTastePostForm.getScallion(),
                    personalTastePostForm.getGarlic(),
                    personalTastePostForm.getMilkFragrance(),
                    personalTastePostForm.getSoySauce(),
                    personalTastePostForm.getCurry(),
                    personalTastePostForm.getCumin(),
                    personalTastePostForm.getFruity(),
                    personalTastePostForm.getVanilla(),
                    personalTastePostForm.getSweetFragrance(),
                    personalTastePostForm.getDairyAllergy(),
                    personalTastePostForm.getProteinAllergy(),
                    personalTastePostForm.getNutAllergy(),
                    personalTastePostForm.getSeafoodAllergy(),
                    personalTastePostForm.getSoyAllergy(),
                    personalTastePostForm.getWheatAllergy(),
                    personalTastePostForm.getPeanutAllergy()
            ));
        }
        return true;
    }

    @Override
    public PersonalTaste getPersonalTaste(String uid) {
        return personalTasteDao.selectByUid(Integer.parseInt(uid));
    }
}
