package pl.com.mmadry.questionnaire.report.web.helper.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.mmadry.questionnaire.report.core.model.UserData;
import pl.com.mmadry.questionnaire.report.core.service.UserDataService;
import pl.com.mmadry.questionnaire.report.web.dto.UserdataDTO;
import pl.com.mmadry.questionnaire.report.web.helper.BaseHelper;

/**
 *
 * @author Mateusz Mądry <mmadry@soft-project.pl>
 */
@Component
public class UserdataHelper extends BaseHelper{
    
    @Autowired
    private UserDataService userDataService;
    
    public List<UserdataDTO> getAllUserData(){
        List<UserdataDTO> dtos = new ArrayList<>();
        List<UserData> uds = userDataService.getElements();
        
        for(UserData ud : uds){
            UserdataDTO dto = new UserdataDTO();
            dto.setEmail(ud.getEmail());
            dto.setId(ud.getId());
            dto.setName(ud.getName());
            dto.setSurname(ud.getSurname());
            dto.setCreationDate(ud.getCreationDate());
            dto.setEnabled(ud.getUser().isEnabled());
            dtos.add(dto);
        }
        
        return  dtos;
    
    }
    
}
