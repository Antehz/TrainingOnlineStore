package by.hrychanok.training.shop.model;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class AuditInfo {

    private Integer updateUserId;
    private Date updateDate;

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
