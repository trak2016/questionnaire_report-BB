package pl.com.mmadry.questionnaire.report.web.helper.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.model.UserData;
import pl.com.mmadry.questionnaire.report.core.service.UserDataService;
import pl.com.mmadry.questionnaire.report.web.dto.ProfilDTO;
import pl.com.mmadry.questionnaire.report.web.helper.BaseHelper;
import pl.com.mmadry.questionnaire.report.web.service.CacheService;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Component
public class ProfilHelper extends BaseHelper{
    
    @Autowired
    private CacheService cacheService;
    @Autowired
    private UserDataService userDataService;
    
    public ProfilDTO getCurrentProfilData(){
        ProfilDTO dto = new ProfilDTO();
        
        UserData userData = cacheService.getLoggedUserData();
        if(userData != null){
            dto.setEmail(userData.getEmail());
            dto.setName(userData.getName());
            dto.setSurname(userData.getSurname());
        }
        
        return dto;
    }
    
    public ProfilDTO changeProfilData(ProfilDTO dto){

        UserData userData = cacheService.getLoggedUserData();
        userData.setName(dto.getName());
        userData.setSurname(dto.getSurname());
        userData = userDataService.save(userData);
        
        if(userData != null){
            dto.setEmail(userData.getEmail());
            dto.setName(userData.getName());
            dto.setSurname(userData.getSurname());
        }
        
        return dto;
    }
    
}
