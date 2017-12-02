package in.ankushs.linode4j.util;

import in.ankushs.linode4j.exception.LinodeException;
import lombok.val;

import java.util.*;

/**
 * Created by ankushsharma on 03/12/17.
 */
public class AuthorizedKeysUtils {

    private AuthorizedKeysUtils(){}
    protected static final Set<String> ACCEPTABLE_TYPES = Collections.unmodifiableSet(
                            new HashSet<String>(
                                    Arrays.asList(
                                            "ssh-dss",
                                            "ssh-rsa",
                                            "ecdsa-sha2-nistp",
                                            "ssh-ed25519")
                            )
    );

    public static void validate(final Set<String> keys){
        if(Objects.nonNull(keys) && !keys.isEmpty()){
            for(val key : keys){
                for(val acceptableType : ACCEPTABLE_TYPES){
                    if(!key.startsWith(acceptableType)){
                        throw new LinodeException("Invalid Key. Key must be from one of the types : " + ACCEPTABLE_TYPES);
                    }
                }
            }
        }
    }

}