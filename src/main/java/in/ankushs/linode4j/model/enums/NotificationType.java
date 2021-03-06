package in.ankushs.linode4j.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.ankushs.linode4j.jackson.NotificationTypeDeserializer;
import in.ankushs.linode4j.util.Strings;
import lombok.Getter;

/**
 * Created by ankushsharma on 30/11/17.
 */
@Getter
@JsonDeserialize(using = NotificationTypeDeserializer.class)
public enum NotificationType {

    UNKNOWN("Unknown"),
    IMPORTANT_TICKET("There is a ticket open on your account that requires your attention."),
    ABUSE_TICKET("There is an abuse-related ticket on your account that requires your attention."),
    OUTAGE("There is a known outage impacting one or more of your services."),
    PENDING_MIGRATION("There is a migration queued for one of your Linodes that you must initiate."),
    SCHEDULED_MIGRATION("There is a migration queued for one of your Linodes."),
    OUTSTANDING_BALANCE("You have a balance on your account that must be paid."),
    XSA("You have a Linode impacted by a Xen Security Advisory which will require migration."),
    SCHEDULED_REBOOT("There is a reboot queued for one of your Linodes.");

    private final String description;

    NotificationType(final String description){
        this.description = description;
    }

    public static NotificationType from(final String code){
        NotificationType result;

        if(!Strings.hasText(code)){
            result = UNKNOWN;
        }
        else{
            switch(code){
                case "important_ticket" : result = IMPORTANT_TICKET; break;
                case "abuse_ticket" : result = ABUSE_TICKET; break;
                case "outage" : result = OUTAGE; break;
                case "pending_migration" : result = PENDING_MIGRATION; break;
                case "scheduled_migration" : result = SCHEDULED_MIGRATION; break;
                case "outstanding_balance" : result = OUTSTANDING_BALANCE; break;
                case "xsa" : result = XSA; break;
                case "scheduled_reboot" : result = SCHEDULED_REBOOT; break;
                default : result = UNKNOWN; break;
            }
        }
        return result;
    }
}
